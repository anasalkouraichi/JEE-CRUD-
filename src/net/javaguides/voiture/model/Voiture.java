package net.javaguides.voiture.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="voiture")
public class Voiture {
 
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 @Column(name="id")
 protected int id;
 
 @Column(name="nom")
 protected String nom;
 
 @Column(name="matricule")
 protected String matricule;

 
 public Voiture() {
 }
 
 public Voiture(String nom, String matricule) {
  super();
  this.nom = nom;
  this.matricule = matricule;
 }

 public Voiture(int id, String nom, String matricule) {
  super();
  this.id = id;
  this.nom = nom;
  this.matricule = matricule;
 }

 public int getId() {
  return id;
 }
 public void setId(int id) {
  this.id = id;
 }
 public String getNom() {
  return nom;
 }
 public void setNom(String nom) {
  this.nom = nom;
 }
 public String getMatricule() {
  return matricule;
 }
 public void setMatricule(String matricule) {
  this.matricule = matricule;
 }
}
