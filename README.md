# AI-Powered SQL Query Generator

This project provides an API endpoint that allows you to query a database using natural language questions. The system generates the SQL query and runs it on a predefined set of tables (`Customer` and `Orders`), providing you with results based on your input.

## Features

- **Natural Language to SQL**: Converts a user’s natural language question into a valid SQL query.
- **Database Interaction**: Executes generated SQL queries on a predefined H2 database with two tables: `Customer` and `Orders`.
- **RESTful API**: A simple GET endpoint allows users to ask questions via query parameters.

## API Endpoint

### `GET /ai/query`

This endpoint accepts a `question` as a query parameter, generates an SQL query based on the question, and executes it on the database.

**Example Request**:

http://localhost:8080/ai/query?question=