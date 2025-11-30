package br.nicolas.learning.entity;

public record Greeting (Long id, String content) {

    @Override
    public String toString() {
        return "Greeting{" +
                "content='" + content + '\'' +
                ", id=" + id +
                '}';
    }
}
