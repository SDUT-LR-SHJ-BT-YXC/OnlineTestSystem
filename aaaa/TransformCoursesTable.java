//
//
//import java.util.*;
//
//public class TransformCoursesTable {
//    static public ArrayList<HashMap<String,Courses>> transform(List<Courses> courses){
//        //System.out.println("TransformCourses: Begin.");
//
//        ArrayList<HashMap<String, Courses>> table = new ArrayList<HashMap<String, Courses>>();
//        Collections.sort(courses, new Comparator<Courses>(){
//            @Override
//            public int compare(Courses o1, Courses o2) {
//                if(o1.getCourseStime() != o2.getCourseStime()){
//                    return  o1.getCourseStime() > o2.getCourseEtime() ? 1: -1;
//                }
//                else{
//                    return o1.getCourseWeekNo() > o2.getCourseWeekNo() ? 1: -1;
//                }
//            }
//        });
//        int pos = 0;
//        for(int i = 0; i < 10; i+= 2){
//            //System.out.println("Loop begain." + i);
//            HashMap<String, Courses> line = new HashMap<String, Courses>();
//            while(pos < courses.size() && courses.get(pos).getCourseStime() == i + 1){
//                Courses c = courses.get(pos);
//                pos++;
//                line.put(c.getCourseWeekNo().toString(), c);
//            }
//            table.add(line);
//        }
//        System.out.println("打印课表：Begain.");
//        for(int i = 0;  i< table.size(); i++){
//            HashMap<String,Courses> l = table.get(i);
//            for(int j = 1; j <= 7; j++){
//                Courses t = l.get(String.valueOf(j));
//                if(t == null){
//                    System.out.print("Null");
//                }
//                else
//                {
//                    System.out.print("i:" + i + ", j:" + j + "," + t .getCourseName());
//                }
//                System.out.print("||");
//            }
//            System.out.println("");
//        }
//        return table;
//    }
//}
