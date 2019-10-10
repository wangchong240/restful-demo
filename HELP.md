# restful设计规范

### 资源路径设计（URI）
URI 不能包含动词，只能是名词（命名名词的时候，要使用小写、数字及下划线来区分多个单词,
通常路径中加版本号可以解决版本不兼容问题）:

    /{version}/{resources}/{resource_id}?offset=0&limit=20

*  【GET】   /v1/users/{user_id} // 查找指定id的用户
*  【GET】   /v1/users // 查询用户信息列表
*  【GET】   /v1/users?offset=0&limit=20 // 查询用户信息后台分页
*  【GET】   /v1/users?sort=age,desc // 查询用户信息年龄排序
*  【POST】  /v1/users // 新建用户信息
*  【PUT】   /v1/users/{user_id} // 更新用户信息(全部字段)
*  【PATCH】 /v1/users/{user_id} // 更新用户信息(部分字段,很少用)
*  【DELETE】/v1/users/{user_id} // 删除用户信息
*  【DELETE】/v1/users/1001,1002 // 删除多个用户信息
*  【批量删除】分成2步完成，第一步发送POST请求，集合所有要删除的IDs（放在redis、数据库）然后返回一个header,然后在利用这个header调用DELETE请求
*  【POST】  /v1/users/{user_id}/roles/{role_id} // 新建用户的角色
*  【POST】  /v1/roles // 新建角色

### 动作设计
动词通常就是五种 HTTP 方法，对应 CRUD 操作:

*  GET：读取（Read）
*  POST：新建（Create）
*  PUT：更新（Update）
*  PATCH：更新（Update），通常是部分更新(很少用)
*  DELETE：删除（Delete）

### 状态码列表（常用）
HTTP状态码:

*  200 OK - [GET]：服务器成功返回用户请求的数据。
*  201 CREATED - [POST/PUT/PATCH]：用户新建或修改数据成功（但是大部分情况下，使用200也是可以的）。
*  202 Accepted - [*]：表示一个请求已经进入后台排队（针对异步请求，或者后台服务需要一定处理时间的请求）
*  204 NO CONTENT - [DELETE]：用户删除数据成功（但是大部分情况下，使用200也是可以的）。
*  400 INVALID REQUEST - [POST/PUT/PATCH]：用户发出的请求有错误，服务器没有进行新建或修改数据的操作，该操作是幂等（幂等的意思是针对一个数据，多次实施相同的操作效果是一致的。比如多次删除一条数据，最后的效果是一样的，即这条数据被删除，那么删除操作是幂等的，而对于++运算符，每次操作的结果都是在上一次数据值上面加1，所以++操作不是幂等的）的。
*  401 Unauthorized - [*]：表示用户没有权限（令牌、用户名、密码错误）。
*  403 Forbidden - [*] 表示用户得到授权（与401错误相对），但是访问是被禁止的。
*  404 NOT FOUND - [*]：用户发出的请求针对的是不存在的记录，服务器没有进行操作，该操作是幂等的。
*  406 Not Acceptable - [GET]：用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）。
*  410 Gone -[GET]：用户请求的资源被永久删除，且不会再得到的。
*  422 Unprocesable entity - [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误。
*  500 INTERNAL SERVER ERROR - [*]：服务器发生错误，用户将无法判断发出的请求是否成功

自定义业务状态码:
*  1000-1999 参数异常：例如 1001 参数异常
*  2000-2999 业务异常：业务预留，根据业务自定义
 

### 响应参数
响应参数为json: {code: Integer, message: String, data: Object}

*  GET	单个对象、集合
*  POST	新增成功的对象
*  PUT/PATCH	更新成功的对象
*  DELETE	空


