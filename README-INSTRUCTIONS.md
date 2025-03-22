CREATE DATABASE movies_db;
\c movies_db;  


CREATE TABLE movies (
    movieId SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    rating DOUBLE PRECISION
);

CREATE TABLE actors (
    actorId SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);


CREATE TABLE ratings (
    ratingId SERIAL PRIMARY KEY,
    rating DOUBLE PRECISION NOT NULL,
    movieId INT NOT NULL,
    CONSTRAINT fk_movie FOREIGN KEY (movieId) REFERENCES movies(movieId) ON DELETE CASCADE
);

CREATE TABLE movie_actor (
    movieId INT NOT NULL,
    actorId INT NOT NULL,
    PRIMARY KEY (movieId, actorId),
    CONSTRAINT fk_movie_actor_movie FOREIGN KEY (movieId) REFERENCES movies(movieId) ON DELETE CASCADE,
    CONSTRAINT fk_movie_actor_actor FOREIGN KEY (actorId) REFERENCES actors(actorId) ON DELETE CASCADE
);
