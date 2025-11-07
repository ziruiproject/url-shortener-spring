# 🧩 URL Shortener API

## Base URL

```
http://localhost:8080
```

---

## **1️⃣ Create Shortened URL**

**Endpoint**

```
POST /api/shorten
```

**Request Body**

```json
{
  "original_url": "https://github.com/ziruiproject",
  "shortened_url": "GitHubKu"
}
```

**Response (200 OK)**

```json
{
  "id": 1,
  "originalUrl": "https://github.com/ziruiproject",
  "shortenedUrl": "GitHubKu",
  "createdAt": "2025-11-07T00:45:00.000Z",
  "updatedAt": "2025-11-07T00:45:00.000Z",
  "deletedAt": null
}
```

---

## **2️⃣ Get All URLs (Paginated)**

**Endpoint**

```
GET /api/urls?page=0&size=10
```

**Response (200 OK)**

```json
{
  "content": [
    {
      "id": 1,
      "original_url": "https://github.com/ziruiproject",
      "shortened_url": "GitHubKu",
      "created_at": "2025-11-07T00:45:00.000Z",
      "updated_at": "2025-11-07T00:45:00.000Z",
      "deleted_at": null
    }
  ],
  "pageable": {
    "page_number": 0,
    "page_size": 10,
    "sort": {
      "sorted": false,
      "empty": true,
      "unsorted": true
    },
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "total_elements": 1,
  "total_pages": 1,
  "last": true,
  "first": true,
  "size": 10,
  "number": 0,
  "number_of_elements": 1,
  "sort": {
    "sorted": false,
    "empty": true,
    "unsorted": true
  },
  "empty": false
}
```

---

## **3️⃣ Redirect Short URL**

**Endpoint**

```
GET /r/{shortenedUrl}
```

**Example**

```
GET /r/GitHubKu
```

**Response (302 Found)**
Redirects user to:

```
https://github.com/ziruiproject
```

If not found → **404 Not Found**

---

## 🧱 Entity Schema

| Field          | Type      | Description                            |
| -------------- | --------- | -------------------------------------- |
| `id`           | Long      | Auto-generated ID                      |
| `originalUrl`  | String    | Original full URL                      |
| `shortenedUrl` | String    | Short custom alias or hash             |
| `createdAt`    | Timestamp | Created timestamp                      |
| `updatedAt`    | Timestamp | Updated timestamp                      |
| `deletedAt`    | Timestamp | Soft-delete timestamp (null if active) |

---