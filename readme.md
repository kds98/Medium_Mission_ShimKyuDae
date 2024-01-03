# 할일

## 회원작업

- [x] GET /member/join : 가입 폼
- [x] POST /member/join : 가입 폼 처리
- [x] GET /member/login : 로그인 폼
- [x] POST /member/login : 로그인 폼 처리
- [x] POST /member/logout : 로그아웃 

## 글 작업

- [x] GET / : 홈
    - 최신글 30개 노출
- [x] GET /post/list : 전체 글 리스트
    - 공개된 글만 노출
- [ ] GET /post/myList : 내 글 리스트
    - 내 글 목록 조회
- [x] GET /post/1 : 1번 글 상세보기
- [ ] GET /post/write : 글 작성 폼
- [ ] POST /post/write : 글 작성 처리
- [ ] GET /post/1/modify : 1번 글 수정 폼
- [ ] PUT /post/1/modify : 1번 글 수정 폼 처리
- [ ] DELETE /post/1/delete : 1번 글 삭제

## 블로그 작업
- [ ] GET /b/user1 : 회원 user1 의 전체 글 리스트
    - 특정 회원의 글 모아보기
- [ ] GET /b/user1/3 : 회원 user1 의 글 중에서 3번글 상세보기
---
# 후반기 미션
## 할 일
- [ ] 필수미션 1 : Member 클래스에 private boolean isPaid 필드를 추가 
  - 해당 필드가 true 인 사람이 로그인할 때, ROLE_PAID 권한도 가지도록(스프링 시큐리티)
  - 해당 필드가 true 이면 유료 멤버십 회원 입니다.
- [ ] 필수미션 2 : Post 클래스에 private boolean isPaid 필드를 추가
  - 해당 필드가 true 인 글은 유료회원이 아닌사람에게는 상세보기(GET /post/1)에서 본문(content)이 나올 자리에 이 글은 유료멤버십전용 입니다. 라는 문구가 나온다.
  - 엔드 포인트
    GET /post/list
    멤버십 회원이 아니라도 글 리스트에서는 멤버십 전용글을 볼 수 있습니다.
    GET /post/1
    유료 멤버십 회원이고 1번 글이 멤버십전용글 이라면 볼 수 있다.
    그 외에는 이 글은 유료멤버십전용 입니다. 노출
- [ ] 필수미션 3 : NotProd 에서 유료멤버십 회원(샘플 데이터)과 유료글(샘플 데이터)을 각각 100개 이상 생성