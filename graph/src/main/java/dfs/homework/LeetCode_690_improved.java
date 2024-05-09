package dfs.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode_690_improved {
    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }
    static HashMap<Integer,Employee> hash=new HashMap<>();
    public static void copying(List<Employee> employees){
        for (Employee employee:employees)  //n
            hash.put(employee.id,employee);
    }
    public static int getImportance(List<Employee> employees, int id) {
        copying(employees);
        return dfs(employees,id);
    }
    public static int dfs(List<Employee> employees, int id){
        int sum=0;
        Employee employee=hash.get(id);
                sum+=employee.importance;
                for (int i : employee.subordinates)  //m
                    sum+=dfs(employees, i);
        return sum;
    }

    // now it is n+ not n* (n for looping on employees)


    public static void main(String[] args) {
        List<Employee> employees=new ArrayList<>();
        employees.add(new Employee(1,5,new ArrayList<>(Arrays.asList(2,3))));
        employees.add(new Employee(2,3,new ArrayList<>()));
        employees.add(new Employee(3,3,new ArrayList<>()));
        System.out.println(getImportance(employees,1));
    }
}
