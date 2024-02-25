//package org.example.buoi3.mappers;
//
//import org.example.buoi3.inputs.StudentDataInput;
//import org.example.buoi3.models.Student;
//import org.example.buoi3.outputs.StudentDataOutput;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Mappings;
//
//@Mapper(componentModel = "spring")
//public interface StudentMapper {
//    // Kinh nghiem => truyen 1 object vao va save lai thi: neu co id thi la chinh sua, neu khong co id thi la tao moi
//    // Duoc dung de tao student hay con goi la convert tu student input => student
//
//    @Mappings({
//            @Mapping(target = "name", source = "studentDataInput.name"),
//            @Mapping(target = "age", source = "studentDataInput.age"),
//            @Mapping(target = "address", source = "studentDataInput.address"),
//            @Mapping(target = "classStudent", source = "studentDataInput.classStudent"),
//            @Mapping(target = "school", source = "studentDataInput.school"),
//            @Mapping(target = "id", source = "id"),
//    })
//    Student toStudent(StudentDataInput studentDataInput,Long id);
//
//    @Mappings({
//            @Mapping(target = "name", source = "name"),
//            @Mapping(target = "age", source = "age"),
//            @Mapping(target = "address", source = "address"),
//            @Mapping(target = "classStudent", source = "classStudent"),
//            @Mapping(target = "school", source = "school"),
//    })
//    StudentDataOutput toStudentDataOutput(Student student);
//}
