# CaoCrudFullStackApp

a basic CRUD full-stack app for code academy's final evaluation

# Setting up the the frontend:

clone the repository

npm install -g sass

create a new folder named "css" inside a static folder

open your terminal and paste the below command

sass --watch crud_app\src\main\resources\static\scss:crud_app\src\main\resources\static\css

this should automatically generate css files inside css folder. if you create css folder in different location, make sure to addjust sass --watch command accordingly, as well as adjust link URL in all html files for linking css.

## Backend setup

Before runing spring boot app, make sure to setup the data base (MYSQL) in application.properties file.

Default options used after running once:

spring.jpa.hibernate.ddl-auto=update

for the first run, you can set it like this:

spring.jpa.hibernate.ddl-auto=create

## Roadmap

- better responsiveness for smaller screens
