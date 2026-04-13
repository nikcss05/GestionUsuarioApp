-- 1. Eliminar la BD si existe
DROP DATABASE IF EXISTS usuarios_db;
-- 2. Cear la BD
CREATE DATABASE usuarios_db;
-- 3. Usar la BD
USE usuarios_db;
-- 4. Crear la tabla de usuarios
CREATE TABLE usuario (

    identificacion VARCHAR(20) PRIMARY KEY,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    indiceCargo INT NOT NULL,
    textoCargo VARCHAR(100) NOT NULL,
    esAdministrador BOOLEAN NOT NULL

);

/*
 private String identificacion;
    private String nombres;
    private String apellidos;
    private int indiceCargo;
    private String textoCargo;
    private boolean esAdministrador;

    */