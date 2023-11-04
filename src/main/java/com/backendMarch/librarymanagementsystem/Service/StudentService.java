package com.backendMarch.librarymanagementsystem.Service;

import com.backendMarch.librarymanagementsystem.DTO.StudentRequestDto;
import com.backendMarch.librarymanagementsystem.DTO.StudentResponseDto;
import com.backendMarch.librarymanagementsystem.DTO.StudentUpdateEmailRequestDto;
import com.backendMarch.librarymanagementsystem.Entity.LibraryCard;
import com.backendMarch.librarymanagementsystem.Entity.Student;
import com.backendMarch.librarymanagementsystem.Enum.CardStatus;
import com.backendMarch.librarymanagementsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public StudentResponseDto addStudent(StudentRequestDto studentRequestDto){

        // Create a student object
        Student student = new Student();
        student.setAge(studentRequestDto.getAge());
        student.setName(studentRequestDto.getName());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setEmail(studentRequestDto.getEmail());

        // crreate a card object
        LibraryCard card = new LibraryCard();
        card.setStatus(CardStatus.ACTIVATED);
        card.setStudent(student);

        // set card in student
        student.setCard(card);

        // check

         Student std=studentRepository.save(student);// will save both student and card
        StudentResponseDto studentResponseDto=StudentResponseDto.builder()
                .cardId(std.getCard().getCardNo())
                .name(std.getName())
                .id(std.getId())
                .email(std.getEmail())
                .build();
        return studentResponseDto;
    }

    public String findByEmail(String email){

       Student student = studentRepository.findByEmail(email);
       return student.getName();
    }

    public StudentResponseDto updateEmail(StudentUpdateEmailRequestDto studentUpdateEmailRequestDto){

        Student student = studentRepository.findById(studentUpdateEmailRequestDto.getId()).get();
        student.setEmail(studentUpdateEmailRequestDto.getEmail());

        // update step
        Student updatedStudent = studentRepository.save(student);


        // convert updated student to response dto
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(updatedStudent.getId());
        studentResponseDto.setName(updatedStudent.getName());
        studentResponseDto.setEmail(updatedStudent.getEmail());

        return studentResponseDto;
    }
    public List<StudentResponseDto> findAllStudent(){
        List<Student> student=studentRepository.findAll();
        List<StudentResponseDto> studentResponseDtos=new ArrayList<>();
        for(Student std:student){

            StudentResponseDto studentResponseDto=StudentResponseDto.builder()
                    .email(std.getEmail())
                    .id(std.getId())
                    .name(std.getName())
                    .build();
            studentResponseDtos.add(studentResponseDto);
        }
        return studentResponseDtos;
    }

}
