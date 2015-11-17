package com.deepakm.designpattern.strategy.sort;

import java.util.Comparator;

/**
 * Created by dmarathe on 11/17/15.
 */
public class Employee implements Entity {
    private int id;
    private String name;
    private int age;
    private int salary;

    public Employee(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.salary = builder.salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public int getId() {
        return id;
    }

    public String toString() {
        String employeeInfo = "[ id = " + getId() + ", "
                + "name = " + getName() + ", "
                + "age = " + getAge() + ", "
                + "salary = " + getSalary() + " ]";
        return employeeInfo;
    }

    public static class Builder {
        private int id;
        private String name;
        private int age;
        private int salary;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public Builder withSalary(int salary) {
            this.salary = salary;
            return this;
        }

        public Employee build() {
            Employee employee = new Employee(this);
            return employee;
        }
    }

    public static Comparator<Employee> SalaryComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getSalary() - o2.getSalary();
        }
    };

    public static Comparator<Employee> AgeComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getAge() - o2.getAge();
        }
    };

    public static Comparator<Employee> NameComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

}
