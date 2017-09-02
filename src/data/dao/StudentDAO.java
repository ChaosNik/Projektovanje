package data.dao;

import java.util.List;

import data.dto.StudentDTO;

public interface StudentDAO {

    public StudentDTO student(String JMB);

    public List<StudentDTO> studenti();

    public boolean dodajStudenta(StudentDTO student);

    public boolean azurirajStudenta(StudentDTO student);

    public boolean obrisiStudenta(String JMB);
}
