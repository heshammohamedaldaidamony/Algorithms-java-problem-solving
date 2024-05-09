package dfs.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_690 {
    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    };
    // the issue with this solution is looping on the whole list O(n*m)
    public static int getImportance(List<Employee> employees, int id) {
        int sum=0;
        for (Employee employee : employees){  //n
            if(employee.id==id) {
                sum+=employee.importance;
                for (int i : employee.subordinates)  //m
                    sum+=getImportance(employees, i);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Employee> employees=new ArrayList<>();
        employees.add(new Employee(1,5,new ArrayList<>(Arrays.asList(2,3))));
        employees.add(new Employee(2,3,new ArrayList<>()));
        employees.add(new Employee(3,3,new ArrayList<>()));
        System.out.println(getImportance(employees,1));
    }
}
