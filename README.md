# project-custom-taglib

Creating a custom tag library using JSP.






# JSP Custom Tag Library Utility



A lightweight Java Server Pages (JSP) custom tag library built to handle common web application patterns—such as duplicate form submission prevention, custom iteration, session state validation, unique ID generation, and data pagination—cleanly without embedding Java scriptlets (<% ... %>) in your views.



## Table of Contents

1\. Features \& Architecture

2\. Installation \& Setup

3\. Tag Reference \& Usage

&#x20;  - \[Form Resubmission Protection]

&#x20;  - \[Pagination Framework]

&#x20;  - \[Iteration \& Looping]

&#x20;  - \[Session \& Utility Tags]

4\. Sample Configuration web.xml

5\. License





\#1 Features \& Architecture



The library is organized into four functional modules:

\-----------------------------------------------------------------------------------------------------

|       Module          |        Classes            |                Purpose                        |

|----------------------------------------------------------------------------------------------------                       |                       |                           |                                               |

| \*\*Form Protection\*\*   | FormIdTagSupport,         | Prevents duplicate form submissions (e.g.,    |

|                       | FormResubmittedTagSupport | browser refresh or double-clicks) using       |

|                       |                           | Synchronizer Tokens.                          |

\-----------------------------------------------------------------------------------------------------

|                       |                           | Provides structured, declarative pagination   |

| \*\*Pagination\*\*        | PaginationTagSupport,     | for tabular datasets and lists.               |

|                       | PageTagSupport,           |                                               |

|                       | PageRowTagSupport,        |                                               |

|                       | PageNumberTagSupport,     |                                               |

|                       | PageProvider,  PageRow    |                                               |

\-----------------------------------------------------------------------------------------------------

|                       |                           | Custom loop control with scripting variable   |

|  \*\*Iteration\*\*        | LoopTagSupport,           | exposure (`TagExtraInfo`) for JSP pages.      | 

|                       | LoopTagExtraInfo          |                                               |

\-----------------------------------------------------------------------------------------------------

|                       |                                  | Conditional rendering based on session |

|   \*\*Session and       | SessionDoesNotContainTagSupport, | attributes and unique identifier       |

|     Utilities\*\*       | UIDTagSupport                    | generation.                            |

\-----------------------------------------------------------------------------------------------------





## 📦 Installation & Setup (From GitHub Releases)

Pre-built binaries are available in the [**Releases**](../../releases) section of this repository—no manual compilation required.

### 1. Download Release Assets
1. Navigate to the [**Releases**](../../releases) page of this repository.
2. Download both files from the latest release:
   `mytags.jar`
   `my-custom-tags.tld`

### 2. Place Files in Your Web Application
Copy the `.jar` into `WEB-INF/lib/` and the `.tld` into `WEB-INF/` 


your-web-app/
└── WEB-INF/
    ├── lib/
    │   └── mytags.jar     
    ├── my-custom-tags.tld    
    └── web.xml



## 📄 Sample Configuration in `web.xml`

Because the `.tld` file is already provided in the [**Releases**](../../releases) section, you do not need to create one manually.

### Option 1: Automatic Discovery (Recommended)
Place your downloaded `.tld` file directly inside `WEB-INF/` (or `WEB-INF/tlds/`). Modern Servlet/JSP containers (such as Apache Tomcat) automatically scan `WEB-INF/` and register the tag library using the `<uri>` defined inside the `.tld` file.

### Option 2: Explicit Mapping via `web.xml`
If you want to assign a custom URI alias or are running an older Servlet container, add a `<jsp-config>` block inside `WEB-INF/web.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="[http://xmlns.jcp.org/xml/ns/javaee](http://xmlns.jcp.org/xml/ns/javaee)"
         xmlns:xsi="[http://www.w3.org/2001/XMLSchema-instance](http://www.w3.org/2001/XMLSchema-instance)"
         xsi:schemaLocation="[http://xmlns.jcp.org/xml/ns/javaee](http://xmlns.jcp.org/xml/ns/javaee) 
         [http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd](http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd)"
         version="4.0">

    <jsp-config>
        <taglib>
            <!-- The URI you will reference in your JSP <%@ taglib %> directive -->
            <taglib-uri>[http://yourdomain.com/jsp/util-tags](http://yourdomain.com/jsp/util-tags)</taglib-uri>
            
            <!-- Path to the .tld file downloaded from Releases -->
            <taglib-location>/WEB-INF/my-custom-tags.tld</taglib-location>
        </taglib>
    </jsp-config>

</web-app>
