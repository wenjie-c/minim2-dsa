package edu.upc.backend;

import edu.upc.backend.models.Team;

/// Parte Model del patron Model-View-Controller
public interface IModel {
    public Team find(int id);
}
