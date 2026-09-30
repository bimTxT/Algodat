public class Entity {
    Object bebas;

    public Entity(Object bebas) {
        this.bebas = bebas;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Entity) {
            return this.bebas.equals(((Entity) obj).bebas);
        }
        return this.bebas.equals(obj);
    }

    @Override
    public String toString() {
        return String.valueOf(this.bebas);
    }
}