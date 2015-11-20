package com.deepakm.dsalgo.problems;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmarathe on 11/20/15.
 */
public class CommonElementsInListsTest {
    @BeforeClass
    public static void setUp() {

    }

    @AfterClass
    public static void tearDown() {

    }

    @Test
    public void testNullParametersReturnsEmptyList() {
        List result = CommonElementsInLists.findCommon(null, new ArrayList<Object>());
        assert result != null;
        assert result.size() == 0;

        result = CommonElementsInLists.findCommon(new ArrayList<Object>(), null);
        assert result != null;
        assert result.size() == 0;
    }

    @Test
    public void testEmptyParamsReturnsEmptyList() {
        List result = CommonElementsInLists.findCommon(new ArrayList<Object>(), new ArrayList<Object>());
        assert result != null;
        assert result.size() == 0;
    }

    @Test
    public void testEqualObjectsAreReturned() {
        List<String> listA = new ArrayList<>();
        listA.add("deepak");
        listA.add("bob");

        List<String> listB = new ArrayList<>();
        listB.add("deepak");
        listB.add("john");

        List result = CommonElementsInLists.findCommon(listA, listB);
        assert result != null;
        assert result.size() == 1;
        assert result.contains("deepak");
    }

    @Test
    public void testEqualObjectsAreReturnedForUserDefiniedType() {
        /**
         * User defined type, with the attributes id and the case insensitive name.
         *
         */
        class Employee {
            private int id;
            private String name;

            public Employee(int id, String name) {
                this.id = id;
                this.name = name;
            }

            @Override
            public int hashCode() {
                int result = id;
                result = 31 * result + (name != null ? name.toUpperCase().hashCode() : 0);
                return result;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Employee other = (Employee) o;

                if (id != other.id) return false;
                return !(name != null ? !name.toUpperCase().equals(other.name.toUpperCase()) : other.name != null);
            }

            @Override
            public String toString(){
                return "[ id = " + id + ", name = " + name + " ]";
            }
        }

        Employee foo = new Employee(1, "foo");
        Employee bar = new Employee(2, "Bar");
        Employee bob = new Employee(2, "baR");
        Employee michael = new Employee(3, "michael");
        Employee chris = new Employee(4, "chris");

        List<Employee> first = new ArrayList<>();
        first.add(foo);
        first.add(bar);
        first.add(michael);

        List<Employee> second = new ArrayList<>();
        second.add(foo);
        second.add(bob);
        second.add(chris);

        List common = CommonElementsInLists.findCommon(first, second);
        assert common != null;
        assert common.size() == 2;
        assert common.contains(foo);
        assert common.contains(bar);
    }
}
