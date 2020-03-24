# springboot-cookies-sample
## How to Use Cookies in Spring Boot

An HTTP Cookie (also known as a web cookie or browser cookie) is a small piece of information stored by the server in the user's browser. The server sets the cookies while returning the response for a request made by the browser. The browser stores the cookies and sends them back with the next request to the same server. Cookies are generally used for session management, user-tracking, and to store user preferences.

Cookies help server remember the client across multiple requests. Without cookies, the server would treat every request as a new client.

In this tutorial, we will learn how to read, set, and remove HTTP cookies in a Spring Boot application.

A cookie is a small piece of data that is stored on the user’s computer. A cookie can be accessed by the browser and send back to the server with any subsequently request.

Cookies are stored as name value pairs. The server uses the unique name or id to access the cookie values. Apart from name and value stored, cookies may also hold some optional attributes such as the maximum age of the cookie, the domain name qualifiers and some comment.

Cookies are very important when building modern web applications. Cookies are mostly used in the following:

Keeping track of the user’s activities so we can provide the users with valid information. This is ideal for most shopping application that rely on cookies to display products that may be of interest to the users.
Cookies are used in session management. Recall that http is a stateless protocol. It treats each request to the server as a new request. To maintain state, we often use session. Cookie is used to keep track of the user by storing the session id. In cases where Cookie is disabled, the session id can be sent as a query parameter.

## Reading cookie with @CookieValue annotation
@CookieValue annotation is used to access data stored within http cookie. All we need to do is to provide the cookie name as parameter. This is a very handy annotation which helps us to binds the cookie value with method argument without the hassle of iterating over all the cookie list from http request and fetching the cookie value from the name.

If Cookie with the given name is not found, we will get into java.lang.IllegalStateException. This imply that we are using this annotation at an ‘illegal’ or inappropriate time. To avoid getting into this exception, its recommended to provide a default value. 

In the above example, if cookie with name sessionId is not found in the http request, Spring will automatically binds the sessionId parameter with the default value ‘none’.

## Writting Cookie using HttpServletResponse
We use addCookie() method  of the javax.servlet.http.HttpServletResponse to write cookies. 

## Using HttpServletRequest to read Cookies
Apart from @CookieValue annotation, we can also use getCookies() method of HttpServletRequest to read a list and interate through to obtain cookie.

@CookieValue annotation is much more easier when working with Cookies than iterating through a list of cookies to find value from name. This annotation came around in Spring 3 Framework.

For step-by-step instructions, please check out the [blog post](https://attacomsian.com/blog/cookies-spring-boot).
[here also](https://dzone.com/articles/how-to-use-cookies-in-spring-boot?edition=510297&utm_source=Daily%20Digest&utm_medium=email&utm_campaign=Daily%20Digest%202019-08-01)
