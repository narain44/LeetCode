package Learn.comparator;

import java.util.*;

public class TestCompare {
    public static void main(String[] a) {

        sortPrimitivesAndWrappers();
        sortEmployee();
    }

    private static void sortEmployee() {
        //sorting object array
        Employee[] empArr = new Employee[4];
        empArr[0] = new Employee(10, "Mikey", 25, 10000);
        empArr[1] = new Employee(20, "Arun", 29, 20000);
        empArr[2] = new Employee(5, "Lisa", 35, 5000);
        empArr[3] = new Employee(1, "Pankaj", 32, 50000);

        //sorting employees array using Comparable interface implementation
        Arrays.sort(empArr);
        System.out.println("\nDefault Id based Sorting of Employees Array:\n" + Arrays.toString(empArr));


        //sorting employees array List using Comparable interface implementation
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee(10, "Mikey", 25, 10000));
        employeeList.add(new Employee(20, "Arun", 29, 20000));
        employeeList.add(new Employee(5, "Lisa", 35, 5000));
        employeeList.add(new Employee(1, "Pankaj", 32, 50000));
        Collections.sort(employeeList);
        System.out.println("\nDefault Id based Sorting of Employees List: ");
        for (Employee employee : employeeList) System.out.print(" " + employee);

        //sorting employees array using Comparator interface implementation
        Comparator<Employee> salaryComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee employee, Employee t1) {
                return (int) (employee.getSalary()-t1.getSalary());
            }
        };
        Arrays.sort(empArr,salaryComparator);
        System.out.println("\n\nSalary COMPARATOR based Sorting of Employees Array:\n" + Arrays.toString(empArr));

        Comparator<Employee> ageComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee employee, Employee t1) {
                return (int) (employee.getAge()-t1.getAge());
            }
        };

        Arrays.sort(empArr,ageComparator);
        System.out.println("\nAGE COMPARATOR based Sorting of Employees Array:\n" + Arrays.toString(empArr));

    }



    private static void sortPrimitivesAndWrappers() {
        //sort primitives array like int array
        int[] intArr = {5, 9, 1, 10};
        Arrays.sort(intArr);
        System.out.println(Arrays.toString(intArr));

        //sorting String array
        String[] strArr = {"A", "C", "B", "Z", "E"};
        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));

        //sorting list of objects of Wrapper classes
        List<String> strList = new ArrayList<String>();
        strList.add("A");
        strList.add("C");
        strList.add("B");
        strList.add("Z");
        strList.add("E");
        Collections.sort(strList);
        for (String str : strList) System.out.print(" " + str);
    }
}
