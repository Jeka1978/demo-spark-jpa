package com.epam.spark.demosparkjpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Evgeny Borisov
 */
@Entity
public class Driver implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;

    public Driver(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Driver() {
    }

    public static DriverBuilder builder() {
        return new DriverBuilder();
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Driver)) return false;
        final Driver other = (Driver) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        if (this.getAge() != other.getAge()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Driver;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        result = result * PRIME + this.getAge();
        return result;
    }

    public String toString() {
        return "Driver(id=" + this.getId() + ", name=" + this.getName() + ", age=" + this.getAge() + ")";
    }

    public static class DriverBuilder {
        private int id;
        private String name;
        private int age;

        DriverBuilder() {
        }

        public Driver.DriverBuilder id(int id) {
            this.id = id;
            return this;
        }

        public Driver.DriverBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Driver.DriverBuilder age(int age) {
            this.age = age;
            return this;
        }

        public Driver build() {
            return new Driver(id, name, age);
        }

        public String toString() {
            return "Driver.DriverBuilder(id=" + this.id + ", name=" + this.name + ", age=" + this.age + ")";
        }
    }
}
