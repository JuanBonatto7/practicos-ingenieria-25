package gameOfLife;

public class Color {
    private String name;

    public Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    // Podrías agregar equals/hashCode si vas a compararlos
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Color other = (Color) obj;
        return name.equalsIgnoreCase(other.name); // compara sin distinguir mayúsculas
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }
}
