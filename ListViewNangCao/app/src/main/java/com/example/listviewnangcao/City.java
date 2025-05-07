package com.example.listviewnangcao;

public class City {
    private String NameCity;

    public String getNameCity() {
        return NameCity;
    }

    public void setNameCity(String nameCity) {
        NameCity = nameCity;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    private int Hinh;

    public String getLinkWiki() {
        return linkWiki;
    }

    public void setLinkWiki(String linkWiki) {
        this.linkWiki = linkWiki;
    }

    private String linkWiki;

    public City(String nameCity, int hinh, String linkWiki) {
        NameCity = nameCity;
        Hinh = hinh;
        this.linkWiki = linkWiki;
    }
}
