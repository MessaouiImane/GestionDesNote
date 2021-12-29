package com.example.gestiondesnote;

import java.util.Objects;

public class Bulletin {
    private String Module;
    private Double Note;


    public Bulletin(String module,double note) {
        Module = module;
        Note = note;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bulletin)) return false;
        Bulletin bulletin = (Bulletin) o;
        return getModule().equals(bulletin.getModule());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModule());
    }

    public Bulletin(){

    }

    public Double getNote(){
        return Note;
    }

    public void setNote(Double note){
        Note = note;
    }

    public String getModule(){
        return Module;
    }

    public void setModule(String module){
        Module=module;
    }

    @Override
    public String toString() {
        return ( getModule()+ "        " + getNote()+ "  ");
    }

}


