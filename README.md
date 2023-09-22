# ImageSearch

### ⭐ Links ⭐
[Figma](https://www.figma.com/file/q781eFFMFKd0bwN4WHoVUz/Untitled?type=design&node-id=1%3A3&mode=design&t=Bm5QMMcJrtLMYAJm-1)

---
#### ⭐과제 해결을 위한 필수 사전 지식⭐

1. Kotlin Language
2. UI Layout
3. Fragment
4. RecyclerView, Adapter
5. SharedPreference
6. OpenAPI, Retrofit, JSON
7. Algorithm (sort..)
---
### ⭐과제 설명⭐

- 이미지를 검색해서 보관함에 수집하는 안드로이드 앱을 작성해주세요.
- 검색은 키워드를 입력하고 검색을 누르면 이미지 검색 결과 리스트를 보여줍니다.
- 이미지 검색 API ( https://developers.kakao.com/docs/latest/ko/daum-search/dev-guide#search-image ) 의 thumbnail_url 필드
- UI는 fragment 2개를 사용합니다. (버튼이나 탭 선택 시 전환)

- 첫 번째 fragment : 검색 결과
  - 검색어를 입력할 수 있습니다.
  - 검색된 이미지 리스트가 나타납니다. 각 아이템에는 이미지와 함께 날짜와 시간을 표시합니다.
  
  - 검색 결과는 최대 80개까지만 표시합니다.
  
  - 리스트에서 특정 이미지를 선택하여 '내 보관함'으로 저장할 수 있습니다.
  - 이미 보관된 이미지는 특별한 표시를 보여줍니다. (좋아요/별표/하트 등)
  - 보관된 이미지를 다시 선택하여 보관함에서 제거 가능합니다.

- 두 번째 fragment: 내 보관함
  - 검색 결과에서 보관했던 이미지들 보입니다.
  
  - 마지막 검색어는 저장되며, 앱 재시작시 마지막 검색어가 입력 필드에 자동으로 입력됩니다.

---
### ⭐개발 요건⭐

- 검색 데이터는 https://developers.kakao.com/product/search 의 Open API를 사용합니다.
- 오픈 소스 사용 가능합니다. (glide등..)

----
### ⭐화면 별 스크린샷⭐

#### Search Fragment

<image src = "https://github.com/MartinKwon94/ImageSearch/assets/139086025/3060bd5e-cf61-426a-a7a1-ecfd539928a7" width = "220" height = "400"/>


---
#### MyBox Fragment

<image src = "https://github.com/MartinKwon94/ImageSearch/assets/139086025/3ee7c330-9862-4004-8d24-4d6ac41d8a4b" width = "220" height = "400"/>

![Footer](https://capsule-render.vercel.app/api?type=waving&color=auto&height=200&section=footer)
