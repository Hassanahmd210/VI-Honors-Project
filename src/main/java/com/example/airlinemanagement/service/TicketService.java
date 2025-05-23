package com.example.airlinemanagement.service;

import com.example.airlinemanagement.model.Ticket;
import com.example.airlinemanagement.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
