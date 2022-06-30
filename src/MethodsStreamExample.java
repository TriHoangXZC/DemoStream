import java.util.*;
import java.util.stream.Collectors;

public class MethodsStreamExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("A", true, 18, 5, Arrays.asList("Toan", "Ly", "Hoa")),
                new Student("A", true, 18, 5, Arrays.asList("Van", "Su", "Hoa")),
                new Student("B", false, 15, 8, Arrays.asList("Toan", "Van", "Anh", "Su")),
                new Student("C", false, 12, 9, Arrays.asList("Cong nghe", "Dia ly")),
                new Student("D", true, 10, 3, Arrays.asList("Anh van", "Hoa", "Sinh")),
                new Student("E", true, 10, 2, Arrays.asList("My thuat", "Am nhac")),
                new Student("F", false, 18, 10, Collections.emptyList())
        );

        /**
         * Filter: Stream filter() được dùng để lọc các phần tử theo một điều kiện xác định
         */

        // Ví dụ lọc các Student có giới tính là nam
//        students.stream()
//                .filter(s -> s.isMale())
//                .forEach(System.out::println);
        // Output
//         Student{name='A', isMale=true, age=18, score=5, subjects=[Toan, Ly, Hoa]}
//         Student{name='A', isMale=true, age=18, score=5, subjects=[Van, Su, Hoa]}
//         Student{name='D', isMale=true, age=10, score=3, subjects=[Anh van, Hoa, Sinh]}
//         Student{name='E', isMale=true, age=10, score=2, subjects=[My thuat, Am nhac]}

        // Ví dụ Sử dụng filter() lọc các Student là nam, có tuổi trên 10, điểm từ trung bình >= 5 trở lên
//        students.stream()
//                .filter(s -> s.isMale() && s.getAge() > 10 && s.getScore() >= 5)
//                .forEach(System.out::println);
        // Output
//        Student{name='A', isMale=true, age=18, score=5, subjects=[Toan, Ly, Hoa]}
//        Student{name='A', isMale=true, age=18, score=5, subjects=[Van, Su, Hoa]}

        /**
         * ForEach: Duyệt các phần tử trong Stream
         */

        // Ví dụ lọc các Student nam và xuất ra màn hình
//        students.stream()
//                .filter(s -> s.isMale())
//                .forEach(System.out::println);
        // Output
//        Student{name='A', isMale=true, age=18, score=5, subjects=[Toan, Ly, Hoa]}
//        Student{name='A', isMale=true, age=18, score=5, subjects=[Van, Su, Hoa]}
//        Student{name='D', isMale=true, age=10, score=3, subjects=[Anh van, Hoa, Sinh]}
//        Student{name='E', isMale=true, age=10, score=2, subjects=[My thuat, Am nhac]}

        /**
         * Collect: collect trả về một collection được chỉ định
         */

        // Ví dụ collect trả về một collection được chỉ định
//        List<Student> studentList = students.stream()
//                .filter(s -> s.isMale())
//                .collect(Collectors.toList());
//
//        Set<String> subjects = students.stream()
//                .flatMap(s -> s.getSubjects().stream())
//                .collect(Collectors.toSet());

        /**
         * Skip, Limit: skip(long n) Trả về một Stream lược bỏ n phần tử kể từ vị trí đầu tiên, còn limit(long l) trả về một Stream với số lượng phần tử tối đa là l.
         */

        // Ví dụ Sử dụng filter() lọc các Student là nam, có tuổi trên 10, điểm từ trung bình trở lên. Quá trình filter sẽ bắt đầu từ sinh viên thứ 2 trong ArrayList xử lý tối đa 3 Student
//        students.stream().skip(1).limit(3)
//                .filter(s -> s.isMale() && s.getAge() > 10 && s.getScore() >= 5)
//                .forEach(System.out::println);
        // Output
//        Student{name='A', isMale=true, age=18, score=5, subjects=[Van, Su, Hoa]}

        /**
         * Map: Stream map() dùng để ánh xạ Stream object sang Stream object khác tương ứng
         */

        // Ví dụ trích danh sách điểm của tất cả các sinh viên
//        List<Integer> scores = students.stream()
//                .map(s -> s.getScore())
//                .collect(Collectors.toList());
//        System.out.println(scores);
        // Output
//        [5, 5, 8, 9, 3, 2, 10]

        /**
         * FlatMap: Stream flatMap() dùng để ánh xạ một Stream collection của object sang một Stream object khác ứng
         */

        // Ví dụ liệt qua tất cả các môn học của tất cả các Student (Không trùng lặp)
//        Set<String> subjects = students.stream()
//                .flatMap(s -> s.getSubjects().stream())
//                .collect(Collectors.toSet());
//        System.out.println(subjects);
        // Output
//        [Van, Su, Cong nghe, Sinh, Anh, Hoa, My thuat, Am nhac, Dia ly, Ly, Anh van, Toan]

        /**
         * Sorted: Stream sorted(Comparator<? super T> comparator) trả về một Stream được sắp xếp theo một comparator truyền vào
         */

        // Ví dụ sắp xếp các Student theo độ tuổi
//        students.stream()
//                .sorted(Comparator.comparingInt(s -> s.getAge()))
//                .forEach(System.out::println);
        // Output
//        Student{name='D', isMale=true, age=10, score=3, subjects=[Anh van, Hoa, Sinh]}
//        Student{name='E', isMale=true, age=10, score=2, subjects=[My thuat, Am nhac]}
//        Student{name='C', isMale=false, age=12, score=9, subjects=[Cong nghe, Dia ly]}
//        Student{name='B', isMale=false, age=15, score=8, subjects=[Toan, Van, Anh, Su]}
//        Student{name='A', isMale=true, age=18, score=5, subjects=[Toan, Ly, Hoa]}
//        Student{name='A', isMale=true, age=18, score=5, subjects=[Van, Su, Hoa]}
//        Student{name='F', isMale=false, age=18, score=10, subjects=[]}

        /**
         * Distinct: Stream distinct() trả về một Stream với các phần tử không trùng lặp
         */

        // Ví dụ liệt kê danh sách tên của tất cả các sinh viên (Không trùng lặp)
//        students.stream()
//                .map(s -> s.getName())
//                .distinct()
//                .forEach(System.out::println);
        // Output
//        A B C D E F

        /**
         * AllMatch: Stream allMatch(Predicate<? super T> predicate) trả về true khi tất cả các phần tử trong Stream thoả mãn điều kiện predicate
         */

        // Ví dụ kiểm tra xem toàn bộ sinh viên nam có điểm trên trung bình hay không?
//        boolean good = students.stream()
//                .filter(s -> s.isMale())
//                .allMatch(s -> s.getScore() > 5);
        // Output
//        false

        /**
         * AnyMatch: Stream anyMatch(Predicate<? super T> predicate) trả về true khi có bất kỳ một phần tử nào thoả điều kiện predicate
         */

        // Ví dụ kiểm tra xem có sinh viên nam nào dưới điểm trung bình hay không?
//        boolean good = students.stream()
//                .filter(s -> s.isMale())
//                .anyMatch(s -> s.getScore() < 5);
        // Output
//        true

        /**
         * Min: Stream min(Comparator<? super T> comparator) trả về phần tử nhỏ nhất dựa theo comaprator truyền vào
         */

        // Ví dụ xuất ra màn hình Student có điểm thấp nhất
//        Student studentMinScore = students.stream()
//                .min(Comparator.comparingInt(s -> s.getScore()))
//                .orElse(null);
//        System.out.println(studentMinScore);
        // Output
//        Student{name='E', isMale=true, age=10, score=2, subjects=[My thuat, Am nhac]}

        /**
         * Max: Stream max(Comparator<? super T> comparator) trả về phần tử lớn nhất dựa theo comaprator truyền vào
         */

        // Ví dụ xuất ra màn hình Student có điểm cao nhất
//        Student studentMaxScore = students.stream()
//                .max(Comparator.comparingInt(s -> s.getScore()))
//                .orElse(null);
//        System.out.println(studentMaxScore);
        // Output
//        Student{name='F', isMale=false, age=18, score=10, subjects=[]}

        /**
         * FindFirst: Stream findFirst() trả về phần tử đầu tiên của Stream
         */

        // Ví dụ
//        Student studentFindFirst = students.stream()
//                .findFirst()
//                .orElse(null);
//        System.out.println(studentFisrt);
        // Output
//        Student{name='A', isMale=true, age=18, score=5, subjects=[Toan, Ly, Hoa]}

        /**
         * FindAny: Stream findAny() trả về phần tử bất kỳ của Stream
         */

        // Ví dụ
//        Student studentFindAny = students.stream()
//                .findAny().orElse(null);
//        System.out.println(studentFindAny);
        // Output
//        Student{name='A', isMale=true, age=18, score=5, subjects=[Toan, Ly, Hoa]}

        /**
         * Count: Stream count() trả về số lượng phần tử trong Stream
         */

        // Ví dụ
//        long countElementOfStream = students.stream().count();
//        System.out.println(countElementOfStream);
        // Output
//        7

        /**
         * Recude: Stream reduce giúp chúng ta lặp lại lập lại một thao tác
         */

        // Ví dụ muốn tính tổng điểm của các Student
//        long sumScoreOfListStudent = students.stream()
//                .mapToInt(s -> s.getScore())
//                .reduce(0, (s1, s2) -> s1 + s2);
//        System.out.println(sumScoreOfListStudent);
        // Output
//        42
    }
}
