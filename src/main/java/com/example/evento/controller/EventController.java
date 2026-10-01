package com.example.evento.controller;

import com.example.evento.model.Event;
import com.example.evento.model.Ticket;
import com.example.evento.model.User;
import com.example.evento.repository.EventRepository;
import com.example.evento.repository.TicketRepository;
import com.example.evento.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EventController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TicketRepository ticketRepository;

    // Display home page
    @GetMapping("/")
    public String home(Model model) {
        List<Event> events = eventRepository.findAll();
        model.addAttribute("events", events);
        return "index";
    }

    // Display login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // Display registration page
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    // Handle user registration with email exist check
    @PostMapping("/register")
    public String registerUser(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam(defaultValue = "USER") String role,
                               Model model) {
        User existingUser = userRepository.findByEmail(email);
        if (existingUser != null) {
            model.addAttribute("error", "Email already registered! Please use a different email.");
            return "register";
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        userRepository.save(user);

        return "redirect:/login?registered";
    }

    // Handle user login strictly checking email and password
    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            Model model) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            if ("ADMIN".equalsIgnoreCase(user.getRole())) {
                return "redirect:/admin";
            }
            return "redirect:/events?userId=" + user.getId();
        }
        return "redirect:/login?error";
    }

    // Display events list
    @GetMapping("/events")
    public String showEvents(@RequestParam Long userId, Model model) {
        List<Event> events = eventRepository.findAll();
        model.addAttribute("events", events);
        model.addAttribute("userId", userId);
        return "events";
    }

    // Display admin dashboard
    @GetMapping("/admin")
    public String showAdminPage(Model model) {
        List<Event> events = eventRepository.findAll();
        model.addAttribute("events", events);
        return "admin";
    }

    // Handle event creation by admin
    @PostMapping("/admin/add-event")
    public String addEvent(@RequestParam String title,
                           @RequestParam String description,
                           @RequestParam String date,
                           @RequestParam String location,
                           @RequestParam Double price) {
        Event event = new Event();
        event.setTitle(title);
        event.setDescription(description);
        event.setDate(date);
        event.setLocation(location);
        event.setPrice(price);
        eventRepository.save(event);
        return "redirect:/admin";
    }

    // Handle event deletion by admin safely
    @PostMapping("/admin/delete-event")
    public String deleteEvent(@RequestParam Long eventId) {
        List<Ticket> tickets = ticketRepository.findAll();
        for (Ticket ticket : tickets) {
            if (ticket.getEvent() != null && ticket.getEvent().getId().equals(eventId)) {
                ticketRepository.delete(ticket);
            }
        }
        eventRepository.deleteById(eventId);
        return "redirect:/admin";
    }

    // Handle ticket booking and QR generation
    @PostMapping("/book-ticket")
    public String bookTicket(@RequestParam Long userId,
                             @RequestParam Long eventId,
                             Model model) {
        User user = userRepository.findById(userId).orElse(null);
        Event event = eventRepository.findById(eventId).orElse(null);

        if (user != null && event != null) {
            Ticket ticket = new Ticket();
            ticket.setUser(user);
            ticket.setEvent(event);
            String ticketCode = "EVT-" + System.currentTimeMillis();
            ticket.setTicketCode(ticketCode);
            ticketRepository.save(ticket);

            model.addAttribute("ticket", ticket);
            model.addAttribute("qrCodeUrl", "https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=" + ticketCode);
            return "ticket";
        }
        return "redirect:/events?userId=" + userId;
    }
}