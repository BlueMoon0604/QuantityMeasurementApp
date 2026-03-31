## 📏✨ Quantity Measurement App







### 🚀 About the Project



###### ✨ Quantity Measurement App is a Spring Boot-based REST API application that performs unit conversions and arithmetic operations across multiple measurement types like:

###### 

###### 📏 Length

###### 🌡️ Temperature

###### ⚖️ Weight

###### 🧪 Volume



###### This project is designed with \*\*clean architecture, modular design, and scalable structure  following industry practices.



### ✨ Features



#### 🔥 Key functionalities of the project:



* 🔄 Convert units (e.g., Feet → Inches, Celsius → Fahrenheit)
* ➕ Perform Addition between quantities
* ➖ Perform Subtraction between quantities
* 📊 Supports multiple measurement types
* 🌐 RESTful APIs using Spring Boot
* 🗄️ In-memory database using H2
* 🧪 Fully tested using Postman
* ⚡ Clean and beginner-friendly code structure



### 

### 🛠️ Tech Stack





###### 

###### | Technology          | Usage                 |

###### | ------------------- | --------------------- |

###### | ☕ Java 17           | Core programming      |

###### | 🌱 Spring Boot      | Backend framework     |

###### | 🗄️ Spring Data JPA | Database interaction  |

###### | 💾 H2 Database      | In-memory database    |

###### | 📦 Maven            | Dependency management |

###### | 🔍 Postman          | API testing           |

###### 

###### 

###### 📂 Project Structure







###### src/main/java/com/measurement/demo

###### │

###### ├── 📁 controller       → Handles REST APIs

###### ├── 📁 service          → Business logic

###### ├── 📁 repository       → Database layer

###### ├── 📁 entity           → Database entities

###### ├── 📁 unit             → Unit conversions (Length, Temp, etc.)

###### ├── 📁 exception        → Custom exception handling





### 🔗 API Endpoints



###### 📌 1. Convert Units

###### 

* ###### POST /api/convert

###### 

###### 📌 2. Add Quantities

###### 

* ###### POST /api/add

###### 

###### 

###### 📌 3. Subtract Quantities

###### 

* ###### POST /api/subtract

###### 

### 

### 📥 Sample Request



#### JSON : 



###### 

###### {

###### &#x20; "value": 10,

###### &#x20; "fromUnit": "FEET",

###### &#x20; "toUnit": "INCHES",

###### &#x20; "quantityType": "LENGTH"

###### }



### 

### 📤 Sample Response



###### 

###### {

###### &#x20; "result": 120.0

###### }





### ▶️ How to Run the Project



###### BASH : 



###### \# Clone the repository

###### git clone https://github.com/your-username/QuantityMeasurementApp.git

###### 

###### \# Navigate to project folder

###### cd QuantityMeasurementApp

###### 

###### \# Run the application

###### mvn spring-boot:run



### 

### 🗄️H2 Database Configuration







###### 🔗 URL: http://localhost:8080/h2-console

###### 

###### | Property | Value                  |

###### | -------- | ---------------------- |

###### | JDBC URL | jdbc:h2:mem:quantitydb |

###### | Username | sa                     |

###### | Password | (leave blank)          |

### 

### 🧪 API Testing



Use Postman to test endpoints:



\* Convert Units

\* Add Values

\* Subtract Values



### 

### 💡 Learnings



###### Through this project, I gained hands-on experience in:



* ###### Spring Boot architecture
* ###### &#x20;REST API development
* ###### &#x20;JPA \& database handling
* ###### &#x20;Clean code practices
* ###### &#x20;Debugging \& API testing
* ###### &#x20; JWT Authentication





### 👩‍💻 Author



###### &#x20; Navya Saxena ✨



