# springboot-cookies-sample
## How to Use Cookies in Spring Boot

A cookie is a small piece of data that is stored on the user’s computer. A cookie can be accessed by the browser and send back to the server with any subsequently request.

Cookies are stored as name value pairs. The server uses the unique name or id to access the cookie values. Apart from name and value stored, cookies may also hold some optional attributes such as the maximum age of the cookie, the domain name qualifiers and some comment.

Cookies are very important when building modern web applications. Cookies are mostly used in the following:

Keeping track of the user’s activities so we can provide the users with valid information. This is ideal for most shopping application that rely on cookies to display products that may be of interest to the users.
Cookies are used in session management. Recall that http is a stateless protocol. It treats each request to the server as a new request. To maintain state, we often use session. Cookie is used to keep track of the user by storing the session id. In cases where Cookie is disabled, the session id can be sent as a query parameter.

For step-by-step instructions, please check out the [blog post](https://attacomsian.com/blog/cookies-spring-boot).
[here also](https://dzone.com/articles/how-to-use-cookies-in-spring-boot?edition=510297&utm_source=Daily%20Digest&utm_medium=email&utm_campaign=Daily%20Digest%202019-08-01)
