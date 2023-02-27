CREATE TABLE authors (
  author_id BIGINT PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(255) NOT NULL,
  username VARCHAR(255) UNIQUE NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  bio TEXT NOT NULL
);

CREATE TABLE posts (
    post_id SERIAL PRIMARY KEY,
    title TEXT NOT NULL,
    content TEXT NOT NULL,
    author_id BIGINT NOT NULL,
    FOREIGN KEY (author_id) REFERENCES authors (author_id) ON DELETE CASCADE
);

CREATE TABLE comments (
  ID BIGINT PRIMARY KEY AUTO_INCREMENT,
  comment_text TEXT,
  post_id BIGINT,
  author_id BIGINT,
  FOREIGN KEY (post_id) REFERENCES posts(post_id),
  FOREIGN KEY (author_id) REFERENCES authors(author_id)
);