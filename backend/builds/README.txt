run-apiserver.bat 
db관련 환경변수 수정가능합니다




============== API ==============

------------------------------
0. 예외
[GET]
192.168.0.171:6805/api/board/boards1

response)
{
    "isSuccess": false,
    "resCode": 500,
    "resMessage": "No static resource api/board/boards1."
}


------------------------------
1. 게시글 등록
[POST]
192.168.0.171:6805/api/board/boards
{
    "title":"테스트 게시글!",
    "content":"테스트 내용!",
    "writerId":"postman"
}

response)
{
    "isSuccess": true,
    "resCode": 200,
    "resMessage": "OK",
    "result": {
        "boardDetail": {
            "createDate": "2025-07-19T16:55:31.060021",
            "latestDate": "2025-07-19T16:55:31.060021",
            "boardIndex": 405,
            "title": "테스트 게시글!",
            "content": "테스트 내용!",
            "viewCount": 0,
            "writerId": "postman",
            "deletedYn": "N"
        }
    }
}


------------------------------
2. 게시글 목록 조회
[GET]
192.168.0.171:6805/api/board/boards   -> default page=1
192.168.0.171:6805/api/board/boards?page=1
192.168.0.171:6805/api/board/boards?page=1&scope=tcw
192.168.0.171:6805/api/board/boards?page=1&search=11
192.168.0.171:6805/api/board/boards?page=1&scope=tcw&search=11

response)
{
    "isSuccess": true,
    "resCode": 200,
    "resMessage": "OK",
    "result": {
        "totalElementCnt": 405,
        "totalPageCnt": 81,
        "pageNum": 0,
        "pageSize": 5,
        "pageHasPrevious": false,
        "pageHasNext": true,
        "pageIsFirst": true,
        "pageIsLast": false,
        "contents": [
            {
                "createDate": "2025-07-19T16:55:31.060021",
                "latestDate": "2025-07-19T16:55:31.060021",
                "boardIndex": 405,
                "title": "테스트 게시글!",
                "content": "테스트 내용!",
                "viewCount": 0,
                "writerId": "postman",
                "deletedYn": "N"
            },
            {
                "createDate": "2025-07-19T16:39:52.312826",
                "latestDate": "2025-07-19T16:39:52.312826",
                "boardIndex": 404,
                "title": "게시글 등록 테스트1",
                "content": "게시글 등록 테스트 내용",
                "viewCount": 0,
                "writerId": "junotest",
                "deletedYn": "N"
            },
            {
                "createDate": "2025-07-19T16:39:52.297827",
                "latestDate": "2025-07-19T16:39:52.297827",
                "boardIndex": 403,
                "title": "제목...200",
                "content": "내용...200",
                "viewCount": 0,
                "writerId": "user0",
                "deletedYn": "N"
            },
            {
                "createDate": "2025-07-19T16:39:52.292873",
                "latestDate": "2025-07-19T16:39:52.292873",
                "boardIndex": 402,
                "title": "제목...199",
                "content": "내용...199",
                "viewCount": 0,
                "writerId": "user9",
                "deletedYn": "N"
            },
            {
                "createDate": "2025-07-19T16:39:52.289751",
                "latestDate": "2025-07-19T16:39:52.289751",
                "boardIndex": 401,
                "title": "제목...198",
                "content": "내용...198",
                "viewCount": 0,
                "writerId": "user8",
                "deletedYn": "N"
            }
        ]
    }
}



------------------------------
3. 게시글 상세조회
[GET]
192.168.0.171:6805/api/board/boards/1

response)
{
    "isSuccess": true,
    "resCode": 200,
    "resMessage": "OK",
    "result": {
        "detail": {
            "createDate": "2025-07-18T19:51:59.0115",
            "latestDate": "2025-07-19T16:59:06.0387129",
            "boardIndex": 1,
            "title": "제목...1",
            "content": "내용...1",
            "viewCount": 4,
            "writerId": "user1",
            "deletedYn": "N"
        }
    }
}



------------------------------
4. 게시글 수정
[PUT]
192.168.0.171:6805/api/board/boards
{
    "boardIndex":404,
    "title":"테스트수정",
    "content":"테스트수정내용"
}

response)
{
    "isSuccess": true,
    "resCode": 200,
    "resMessage": "OK",
    "result": {
        "modified": {
            "createDate": "2025-07-19T16:39:52.312826",
            "latestDate": "2025-07-19T18:12:36.9482043",
            "boardIndex": 404,
            "title": "테스트수정",
            "content": "테스트수정내용",
            "viewCount": 0,
            "writerId": "junotest",
            "deletedYn": "N"
        }
    }
}



------------------------------
5. 게시글 삭제
[DELETE]
192.168.0.171:6805/api/board/boards/405

response)
{
    "isSuccess": true,
    "resCode": 200,
    "resMessage": "OK",
    "result": {
        "deleted": {
            "createDate": "2025-07-19T16:55:31.060021",
            "latestDate": "2025-07-19T17:02:00.2824154",
            "boardIndex": 405,
            "title": "테스트 게시글!",
            "content": "테스트 내용!",
            "viewCount": 0,
            "writerId": "postman",
            "deletedYn": "Y"
        }
    }
}
