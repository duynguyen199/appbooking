//package org.example.buoi3.repositories;
//
//import org.example.buoi3.inputs.GetListStudentInput;
//import org.example.buoi3.models.Student;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface StudentRepository extends JpaRepository<Student, Long> {
//    @Query("select s " +
//            "from Student s " +
//            "where (:name is null or upper(s.name) like upper(concat('%',:name,'%')) )" +
//            "and (:age is null or s.age = :age )" +
//            "and (:address is null or upper(s.address) like upper(concat('%',:address,'%')) )" +
//            "and (:classStudent is null or upper(s.classStudent) like upper(concat('%',:classStudent,'%')) )" +
//            "and (:school is null or s.school like concat('%',:school,'%') )"
//    )
//    List<Student> getListStudent(@Param("name") String name,
//                                 @Param("age") Integer age,
//                                 @Param("address") String address,
//                                 @Param("classStudent") String classStudent,
//                                 @Param("school") String school,
//                                 Pageable pageable
//    );
//    @Query("select s " +
//            "from Student s " +
//            "where (:keyword is null or upper(s.name) like upper(concat('%',:keyword,'%')) )" +
////            "and (:keyword is null or s.age = cast(:keyword as numeric(10,2) ) ) " +
//            "or (:keyword is null or upper(s.address) like upper(concat('%',:keyword,'%')) )" +
//            "or (:keyword is null or upper(s.classStudent) like upper(concat('%',:keyword,'%')) )" +
//            "or (:keyword is null or s.school like concat('%',:keyword,'%') )")
//    List<Student> getListByKeyWord(@Param("keyword") String keyword);
//}
