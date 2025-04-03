<h1>📌 Quiz Application - Backend</h1>
    
<p>A microservices-based Quiz Application built using <strong>Spring Boot</strong> and <strong>PostgreSQL</strong>, focused on providing RESTful APIs for quiz management.</p>
    
<h2>📢 Features</h2>
    <ul>
        <li>✅ Add, delete, and generate quiz questions dynamically.</li>
        <li>✅ Create and retrieve quizzes.</li>
        <li>✅ Calculate quiz scores.</li>
        <li>✅ Microservices registered in <strong>Eureka</strong> for service discovery.</li>
        <li>✅ Inter-microservice communication using <strong>Feign Client</strong>.</li>
        <li>✅ API endpoints tested using <strong>Postman</strong>.</li>
    </ul>
<h2>⚙️ Tech Stack</h2>
    <ul>
        <li>🛠️ <strong>Backend:</strong> Spring Boot</li>
        <li>💾 <strong>Database:</strong> PostgreSQL</li>
        <li>🛜 <strong>Service Discovery:</strong> Eureka</li>
        <li>🔄 <strong>Inter-Service Communication:</strong> Feign Client</li>
        <li>🔍 <strong>Testing:</strong> Postman</li>
    </ul>
<h2>🚀 Getting Started</h2>
    <p>Follow these steps to run the project locally:</p>
    <ol>
        <li>Clone the repository:
            <pre><code>git clone https://github.com/yourusername/quiz-application-backend.git</code></pre>
        </li>
        <li>Navigate to the project directory:
            <pre><code>cd quiz-application-backend</code></pre>
        </li>
        <li>Run the application:
            <pre><code>mvn spring-boot:run</code></pre>
        </li>
    </ol>
    
<h2>📡 API Endpoints</h2>
    <p>Base URL: <code>http://localhost:8080</code></p>
    <table border="1" cellspacing="0" cellpadding="5">
        <tr>
            <th>Method</th>
            <th>Endpoint</th>
            <th>Description</th>
        </tr>
        <tr>
            <td>POST</td>
            <td><code>/questions/add</code></td>
            <td>Add a new question</td>
        </tr>
        <tr>
            <td>DELETE</td>
            <td><code>/questions/{id}</code></td>
            <td>Delete a question by ID</td>
        </tr>
        <tr>
            <td>GET</td>
            <td><code>/quiz/generate</code></td>
            <td>Generate a quiz</td>
        </tr>
        <tr>
            <td>POST</td>
            <td><code>/quiz/submit</code></td>
            <td>Submit answers and calculate score</td>
        </tr>
    </table>

<h2> Screenshots </h2>
<img width="1042" alt="petclinic-screenshot" src="https://github.com/user-attachments/assets/deb4bfe7-1aa8-4f0c-84a9-469e750f1430">
![Screenshot (299)]()
![Screenshot (300)](https://github.com/user-attachments/assets/deb4bfe7-1aa8-4f0c-84a9-469e750f1430)


<h2>🤝 Contribution</h2>
    <p>Feel free to contribute to this project by submitting issues or pull requests.</p>
    
<h2>📜 License</h2>
    <p>This project is licensed under the <strong>MIT License</strong>.</p>
