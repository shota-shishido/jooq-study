CREATE TABLE "tasks" (
    "id" SERIAL PRIMARY KEY,
    "title" varchar(255) NOT NULL,
    "description" text,
    "status" bool NOT NULL DEFAULT false,
    "created_at" timestamptz DEFAULT CURRENT_TIMESTAMP,
    "updated_at" timestamptz DEFAULT CURRENT_TIMESTAMP,
);

CREATE TABLE "user" (
  "id" SERIAL PRIMARY KEY,
  "name" VARCHAR(255)
);

--CREATE TABLE "article" (
--  "id" SERIAL PRIMARY KEY,
--  "title" VARCHAR(255),
--  "content" TEXT,
--  "created_at" TIMESTAMP DEFAULT CURRENT_TIMESTAMP
--);

