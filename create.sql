SET MODE PostgreSQL;

CREATE DATABASE news_api;
\c news_api;

CREATE TABLE users (id serial PRIMARY KEY,name varchar,position varchar,role varchar,department varchar);

CREATE TABLE news (id serial PRIMARY KEY,title varchar,description varchar,department varchar);

CREATE TABLE departments (id serial PRIMARY KEY,departmentName varchar,description varchar,numberOfPeople varchar);

CREATE DATABASE news_api_test WITH TEMPLATE news_api;
