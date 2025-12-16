package edu.upc.backend;

import edu.upc.backend.models.Team;

import javax.naming.NameNotFoundException;

/// Parte Model del patron Model-View-Controller
public interface IModel {
    public Team find(int id);
    public Team find(String teamName) throws NameNotFoundException;
}
