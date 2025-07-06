<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Brainstorming - Backend Project</title>
</head>
<body>

<h1>Brainstorming - Backend Project</h1>

<h2>Overview</h2>
<p><strong>Brainstorming</strong> is a backend project inspired by platforms like <strong>LeetCode</strong> and <strong>Codeforces</strong>. It allows users to practice coding problems and participate in contests. The platform is designed with <strong>horizontal scalability</strong> to reduce user wait times for code evaluation results. This is achieved using a <strong>microservice architecture</strong>, featuring a central <strong>Brainstorming server</strong> and multiple <strong>Tester servers</strong>, which can be dynamically scaled as needed.</p>

<p>Key technologies used include <strong>Java Spring Boot</strong>, <strong>SQL</strong>, <strong>MongoDB</strong>, <strong>Kafka</strong> for inter-service communication, and <strong>JWT</strong> authentication with <strong>Spring Security</strong>. The system is optimized for performance using <strong>indexing</strong>, <strong>pagination</strong>, and <strong>multi-threading</strong> on Tester servers to handle concurrent code submissions.</p>

<h2>Key Features</h2>
<ul>
    <li><strong>Problem Solving Platform</strong>: Users can practice coding problems, submit solutions, and get real-time feedback.</li>
    <li><strong>Contests</strong>: Users can participate in coding contests organized on the platform.</li>
    <li><strong>Microservice Architecture</strong>: Supports horizontal scaling by adding multiple Tester servers to handle large volumes of submissions concurrently.</li>
    <li><strong>Dual Database System</strong>:
        <ul>
            <li><strong>SQL</strong>: Stores structured data like users, problems, submissions, and contest details.</li>
            <li><strong>MongoDB</strong>: Stores large unstructured data such as test cases and user-submitted code solutions.</li>
        </ul>
    </li>
    <li><strong>Kafka Integration</strong>: Enables communication between the Brainstorming server and Tester servers, serving as a load balancer for handling submission processing.</li>
    <li><strong>JWT Authentication</strong>: Ensures secure access with <strong>Spring Security</strong> and <strong>JWT tokens</strong>.</li>
    <li><strong>Concurrency Handling</strong>: Multi-threading is implemented on Tester servers to handle concurrent code execution requests.</li>
    <li><strong>Code Compilation</strong>: The current system supports code submission and compilation for <strong>C++</strong> only.</li>
    <li><strong>Data Consistency</strong>: All servers share the same databases (SQL and MongoDB) to ensure consistency in user data, submissions, and results.</li>
    <li><strong>Efficient API Responses</strong>: Implemented <strong>indexing</strong> and <strong>pagination</strong> for faster API performance and efficient handling of large datasets.</li>
</ul>

<h2>Tech Stack</h2>
<ul>
    <li><strong>Java Spring Boot</strong>: Backend framework.</li>
    <li><strong>SQL (MySQL/PostgreSQL)</strong>: For structured data (e.g., users, submissions, problems).</li>
    <li><strong>MongoDB</strong>: For unstructured, large-scale data (e.g., test cases, code solutions).</li>
    <li><strong>Kafka</strong>: For distributed messaging between Brainstorming and Tester servers.</li>
    <li><strong>JWT & Spring Security</strong>: For authentication and security.</li>
    <li><strong>Multi-threading</strong>: To handle concurrent execution of user-submitted code.</li>
    <li><strong>Apache Kafka</strong>: For producer-consumer communication between servers.</li>
</ul>

<h2>System Architecture</h2>
<ul>
    <li><strong>Brainstorming Server</strong>: 
        <ul>
            <li>Acts as the central hub of the platform, handling user management, problem/contest creation, submissions, and result storage.</li>
            <li>Runs on port <strong>8080</strong>.</li>
            <li>Communicates with <strong>Tester Servers</strong> via Kafka by producing submission messages.</li>
        </ul>
    </li>
    <li><strong>Tester Servers</strong>:
        <ul>
            <li>These servers are horizontally scalable; more Tester servers can be added to handle increased traffic.</li>
            <li>Responsible for consuming submission messages from Kafka, compiling, and executing the code (currently only supports <strong>C++</strong>).</li>
            <li>Uses multi-threading to handle multiple submissions concurrently.</li>
            <li>Directly updates the submission results in the shared SQL database for consistency.</li>
            <li>Each Tester server can be deployed on different ports, such as <strong>9090</strong>, <strong>9091</strong>, etc.</li>
        </ul>
    </li>
    <li><strong>Kafka</strong>:
        <ul>
            <li>Acts as a <strong>load balancer</strong> between the Brainstorming server and the Tester servers.</li>
            <li>Brainstorming server pushes user submissions to Kafka topics.</li>
            <li>Tester servers consume these messages, compile the code, run it against test cases, and update the result in the SQL database.</li>
        </ul>
    </li>
</ul>


<ul>
    <li><strong>Scale Tester Servers</strong>
        <ul>
            <li>You can deploy multiple Tester servers, each consuming submission tasks from Kafka. This helps in balancing the load, reducing response times, and efficiently processing submissions.</li>
        </ul>
    </li>
</ul>
<h2>Usage</h2>
<ol>
    <li><strong>Brainstorming Server</strong>: Handles:
        <ul>
            <li>User management (registration, login with JWT).</li>
            <li>Problem retrieval and contest organization.</li>
            <li>Submission of code.</li>
            <li>Managing upcoming contests and owner-only operations (like adding new problems or uploading test cases).</li>
            <li>Communication with Kafka to dispatch submission requests.</li>
        </ul>
    </li>
    <li><strong>Tester Servers</strong>: Responsible for:
        <ul>
            <li>Consuming user submissions from Kafka.</li>
            <li>Compiling and running <strong>C++</strong> code.</li>
            <li>Handling concurrent submissions using multi-threading.</li>
            <li>Storing the results directly in the shared SQL database.</li>
        </ul>
    </li>
    <li><strong>Data Flow</strong>:
        <ul>
            <li>Users submit code through the Brainstorming server.</li>
            <li>Submissions are pushed to Kafka topics.</li>
            <li>Tester servers consume these messages, compile the code, run it against test cases, and update the result in the SQL database.</li>
        </ul>
    </li>
</ol>
</body>
</html>
