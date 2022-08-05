package com.example.songapi;

import java.util.Objects;

public class Song {
    private Integer id;
    private String nome;
    private String artista;
    private String album;
    private String anoLancamento;

    public Song(Integer id, String nome, String artista, String album, String anoLancamento) {
        this.id = id;
        this.nome = nome;
        this.artista = artista;
        this.album = album;
        this.anoLancamento = anoLancamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Song)) return false;
        Song song = (Song) obj;
        return getId().equals(song.getId()) && getNome().equals(song.getNome()) && getArtista().equals(song.getArtista()) && getAlbum().equals(song.getAlbum()) && getAnoLancamento().equals(song.getAnoLancamento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getArtista(), getAlbum(), getAnoLancamento());
    }

    @Override
    public String toString() {
        return  ", Musica='" + getNome() + '\'' +
                ", Artista='" + getArtista() + '\'' +
                ", Album='" + getAlbum() + '\'' +
                ", Ano de lancamento='" + getAnoLancamento() + '\'' +
                '}';
    }
}
