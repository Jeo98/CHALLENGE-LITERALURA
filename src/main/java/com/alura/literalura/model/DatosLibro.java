package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosLibro(@JsonAlias("title") String titulo, @JsonAlias("languages") List<String> idiomasLibro,
                         @JsonAlias("authors") List<DatosAutor> autor, @JsonAlias("download_count") int cantidadDescargas,
                         @JsonAlias("subjects") List<String> temaDelLibro, @JsonAlias("copyright") boolean copyright,
                         @JsonAlias("count") int CantidadLibrosCargados,@JsonAlias("id") int id )  {


}
