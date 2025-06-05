# architecture

*  A **configuration**  of **architectural elements**,

   Where these elements are **constrained in how they relate to each other**

*  **architectural elements**

  * Component
    * An **abstract unit** consisting of
      - **software instructions** + **internal state**
    * Not defined by its **internal implementation**,
      - but by the **interface it exposes**
    * Its role is to **transform data**
      - **through that interface**
    * ex. loading into memory from secondary storage, performing calculation, translatigm to a different form, encapsulation with other data
    
  * Connector
    * communication mechanisms between components
    
    * ex. shared representations, remote procedure calls, message-passing protocols, and data streams
    
      > * shared representations
      >   * A common format of data understood by both components (e.g., client and server)
      >   * *Examples:* HTML, JSON
      > * remote procedure calls
      >   *  One component invokes functionality of another as if it were a local function, over the network
      >   * *Examples:* gRPC, SOAP
      > * message-passing protocols
      >   * Explicit messages are exchanged between components for communicationbetween components
      >   * ex.Kafka, MQTT, AMQP, POST of HTTP
      > * data streams
      >   * Continuous flow of data between components
      >   * ex. video streaming, real time trasmission of sensor data, websocket based communication
    
  * Data
    * Information transferred between components via connectors
    * Not permanently stored or hidden inside a component  
    * ex. byte sequences, message, marshalled  parameters, serialized object

*  **Configuration**

   - A concrete structure that shows how components are connected via connectors and what data they exchange at runtime
   - Helps understand both the current system state and the set of all possible system states
   - ex.  the overall relationship where a client communicates with a server via HTTP

*  **Architectural Properties**

   *  Includes:
      - Functional properties — what the system does
      - Non-functional properties (a.k.a. *quality attributes*) — how well the system performs or behaves
        - Examples of quality attributes:
          - *Evolvability* — how easily the system can change
          - *Reusability* — how easily components can be reused
          - *Dynamic extensibility* — how easily functionality can be added at runtime
   *  Example:
      - In the *pipeline and filter* architecture style, applying the constraint of interface generality leads to:
        - Reusability of components
        - Configurable system composition

*  **Architectural Styles**

   *  coordinated set of architectural constraints that defines structural pattern, relationships between elements and how to use connector etc. 
   *  ex. REST

*  found at multi levels within software systems

---

# Network-based Application Architecture

* network based architecture VS software architecture
  * 

network based system 



# REST

* Representational
* State
* Transfer
* for distributed hypermedia system
* evolution process

  1. Null Style

     ![image-20250605143656699](./assets/image-20250605143656699.png)

  2. Client-Server

     * 
* 조합된 제약들
  * client-server
    * 사용자 인터페이스와 데이터 저장 분리 ➡️ 독립적인 개발 가능
  * stateless
    * 서버는 클라이언트의 상태를 저장하지 않음 ➡️ 각 요청 독립적
  * cacheable
    * 응답에서 캐시 가능 여부 지정 ➡️ 성능과 확장성 향상
  * uniform interface
    * 단순하고 일관된 인터페이스 사용
  * layered system
    * 중간 서버를 둘 수 있음 ➡️ 보안, 로드 밸런싱, 캐싱 등 기능 분리 가능
  * code-on-demand
    * client가 server에게서 코드를 받아 실행 가능
  * 목적
    * 인터넷 규모 확장성
    * 구성요소 독립 배포
    * 중간 구성 요소 활용 극대화
    * 성능 개선 및 보안 강화
    * 인터페이스 일반화
  * 활용
    * HTTP, URI 설계에 적용됨
      * RESTfulAPI 설계의 기반이 됨
* 