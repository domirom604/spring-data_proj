/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.aei.ior.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dromanow
 */
public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
