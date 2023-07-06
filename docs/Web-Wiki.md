---
title: Web-Wiki v1.0.0
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
code_clipboard: true
highlight_theme: darkula
headingLevel: 2
generator: "@tarslib/widdershins v4.0.17"

---

# Web-Wiki

> v1.0.0

Base URLs:

* <a href="http://127.0.0.1:8888">开发环境: http://127.0.0.1:8888</a>

# EBook

## GET 获取列表

GET /ebook/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|page|query|string| 是 |none|
|size|query|string| 是 |none|
|name|query|string| 否 |模糊查询|

> 返回示例

> 200 Response

```json
{
  "success": true,
  "message": "string",
  "data": {
    "total": 0,
    "list": [
      {
        "id": 0,
        "name": "string",
        "category1Id": null,
        "category2Id": 0,
        "description": "string",
        "cover": "string",
        "docCount": null,
        "viewCount": null,
        "voteCount": null
      }
    ]
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» success|boolean|true|none||none|
|» message|string|true|none||none|
|» data|object|true|none||none|
|»» total|integer|true|none||none|
|»» list|[object]|true|none||none|
|»»» id|integer|true|none||none|
|»»» name|string|true|none||none|
|»»» category1Id|null|true|none||none|
|»»» category2Id|integer¦null|true|none||none|
|»»» description|string|true|none||none|
|»»» cover|string¦null|true|none||none|
|»»» docCount|null|true|none||none|
|»»» viewCount|null|true|none||none|
|»»» voteCount|null|true|none||none|

## POST 新增电子书

POST /ebook/save

> Body 请求参数

```json
{
  "name": "string",
  "description": "string",
  "cover": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» name|body|string| 是 |none|
|» description|body|string| 是 |none|
|» cover|body|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "success": true,
  "message": "string",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» success|boolean|true|none||none|
|» message|string|true|none||none|
|» data|null|true|none||none|

## DELETE 删除电子书

DELETE /ebook/delete/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|
|token|header|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "success": true,
  "message": "string",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» success|boolean|true|none||none|
|» message|string|true|none||none|
|» data|null|true|none||none|

## PATCH 更新电子书

PATCH /ebook/update

> Body 请求参数

```json
{
  "id": 0,
  "name": "string",
  "description": "string",
  "cover": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|header|string| 是 |none|
|body|body|object| 否 |none|
|» id|body|integer| 是 |none|
|» name|body|string| 否 |none|
|» description|body|string| 否 |none|
|» cover|body|string| 否 |none|

> 返回示例

> 200 Response

```json
{
  "success": true,
  "message": "string",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» success|boolean|true|none||none|
|» message|string|true|none||none|
|» data|null|true|none||none|

# Category

## GET 分页查询Category

GET /category/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|page|query|string| 否 |none|
|size|query|string| 否 |none|
|token|header|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "success": true,
  "message": "string",
  "data": {
    "total": 0,
    "list": [
      {
        "id": 0,
        "parent": 0,
        "name": "string",
        "sort": 0
      }
    ]
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» success|boolean|true|none||none|
|» message|string|true|none||none|
|» data|object|true|none||none|
|»» total|integer|true|none||none|
|»» list|[object]|true|none||none|
|»»» id|integer|true|none||none|
|»»» parent|integer|true|none||none|
|»»» name|string|true|none||none|
|»»» sort|integer|true|none||none|

## GET 查询全部类目

GET /category/all

> 返回示例

> 200 Response

```json
{
  "success": true,
  "message": "string",
  "data": [
    {
      "id": 0,
      "parent": 0,
      "name": "string",
      "sort": 0
    }
  ]
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» success|boolean|true|none||none|
|» message|string|true|none||none|
|» data|[object]|true|none||none|
|»» id|integer|true|none||none|
|»» parent|integer|true|none||none|
|»» name|string|true|none||none|
|»» sort|integer|true|none||none|

## PATCH 修改类目

PATCH /category/update

> Body 请求参数

```json
{
  "id": 0,
  "parent": 0,
  "name": "string",
  "sort": 0
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|header|string| 是 |none|
|body|body|object| 否 |none|
|» id|body|integer| 是 |none|
|» parent|body|integer| 否 |none|
|» name|body|string| 否 |none|
|» sort|body|integer| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 新增类目

POST /category/save

> Body 请求参数

```json
{
  "parent": 0,
  "name": "string",
  "sort": 0
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|header|string| 是 |none|
|body|body|object| 否 |none|
|» parent|body|integer| 否 |none|
|» name|body|string| 否 |none|
|» sort|body|integer| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## DELETE 删除类目

DELETE /category/delete/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|
|token|header|string| 是 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# Doc

## GET 获取列表

GET /doc/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|page|query|string| 否 |none|
|size|query|string| 否 |none|
|token|header|string| 是 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取EBook下所有文档

GET /doc/all/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 新增电子书文档

POST /doc/save

> Body 请求参数

```json
{
  "ebookId": 0,
  "parent": 0,
  "name": "string",
  "sort": 0,
  "viewCount": 0,
  "voteCount": 0,
  "content": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|header|string| 是 |none|
|body|body|object| 否 |none|
|» ebookId|body|integer| 是 |none|
|» parent|body|integer| 是 |none|
|» name|body|string| 是 |none|
|» sort|body|integer| 是 |none|
|» viewCount|body|integer| 否 |none|
|» voteCount|body|integer| 否 |none|
|» content|body|string| 是 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## PATCH 更新电子书文档

PATCH /doc/update

> Body 请求参数

```json
{
  "id": 0,
  "ebookId": 0,
  "parent": 0,
  "name": "string",
  "sort": 0,
  "viewCount": 0,
  "voteCount": 0,
  "content": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|header|string| 否 |none|
|body|body|object| 否 |none|
|» id|body|integer| 是 |none|
|» ebookId|body|integer| 是 |none|
|» parent|body|integer| 是 |none|
|» name|body|string| 是 |none|
|» sort|body|integer| 是 |none|
|» viewCount|body|integer| 否 |none|
|» voteCount|body|integer| 否 |none|
|» content|body|string| 是 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## DELETE 删除电子书文档

DELETE /doc/delete/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|
|token|header|string| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 访问++

GET /doc/find-content/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|
|token|header|string| 是 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 点赞++

GET /doc/vote/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|
|token|header|string| 是 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# User

## POST 修改密码

POST /user/reset-password

> Body 请求参数

```json
{
  "id": 0,
  "password": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|header|string| 是 |none|
|body|body|object| 否 |none|
|» id|body|integer| 是 |none|
|» password|body|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "success": true,
  "message": null,
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» success|boolean|true|none||none|
|» message|null|true|none||none|
|» data|null|true|none||none|

## POST 新增用户

POST /user/save

> Body 请求参数

```json
{
  "loginName": "string",
  "nickname": "string",
  "password": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|header|string| 是 |none|
|body|body|object| 否 |none|
|» loginName|body|string| 是 |none|
|» nickname|body|string| 是 |none|
|» password|body|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "success": true,
  "message": "string",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» success|boolean|true|none||none|
|» message|string|true|none||none|
|» data|null|true|none||none|

## PATCH 更新用户信息（不重置密码）

PATCH /user/save

> Body 请求参数

```json
{
  "loginName": "string",
  "nickname": "string",
  "password": "string",
  "id": 0
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|header|string| 否 |none|
|body|body|object| 否 |none|
|» loginName|body|string| 是 |none|
|» nickname|body|string| 是 |none|
|» password|body|string| 是 |none|
|» id|body|integer| 是 |none|

> 返回示例

> 200 Response

```json
{
  "success": true,
  "message": null,
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» success|boolean|true|none||none|
|» message|null|true|none||none|
|» data|null|true|none||none|

## GET 查询所有用户

GET /user/list

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|page|query|string| 否 |none|
|size|query|string| 否 |none|
|token|header|string| 否 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## DELETE 删除用户

DELETE /user/delete/{id}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|id|path|string| 是 |none|
|token|header|string| 否 |none|

> 返回示例

> 200 Response

```json
{
  "success": true,
  "message": null,
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» success|boolean|true|none||none|
|» message|null|true|none||none|
|» data|null|true|none||none|

## POST 用户登录

POST /user/login

> Body 请求参数

```json
{
  "loginName": "string",
  "password": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» loginName|body|string| 是 |none|
|» password|body|string| 是 |none|

> 返回示例

> 200 Response

```json
{
  "success": true,
  "message": "string",
  "data": {
    "id": 0,
    "loginName": "string",
    "name": null,
    "token": "string"
  }
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» success|boolean|true|none||none|
|» message|string|true|none||none|
|» data|object|true|none||none|
|»» id|integer|true|none||none|
|»» loginName|string|true|none||none|
|»» name|null|true|none||none|
|»» token|string|true|none||none|

## GET 用户登出

GET /user/logout/{token}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|path|string| 是 |none|
|token|header|string| 否 |none|

> 返回示例

> 200 Response

```json
{
  "success": true,
  "message": "string",
  "data": null
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» success|boolean|true|none||none|
|» message|string|true|none||none|
|» data|null|true|none||none|

# Snapshot

## GET 获取当日趋势

GET /ebook-snapshot/get-statistic

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|header|string| 是 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 获取30日趋势

GET /ebook-snapshot/get-30-statistic

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|header|string| 是 |none|

> 返回示例

> 200 Response

```json
{}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 数据模型

