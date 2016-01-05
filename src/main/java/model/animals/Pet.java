package model.animals;

/**
 * Created by Влад on 26.11.2015.
 */
public abstract class Pet {
    /**
     * имя животного
     */
    protected String name;

    /**
     * Конструктор
     *
     * @param name имя питомца
     */
    public Pet(String name) {
        this.name = name;
    }

    /**
     * Устанавливаем имя питомца
     *
     * @param name имя питомца
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возращает имя питомца
     *
     * @return имя питомца
     */
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "name='" + name + '\'' +
                '}';
    }
}