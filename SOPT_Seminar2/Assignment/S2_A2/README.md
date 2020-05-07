# ItemDecoration
ItemDecoration 클래스는 RecyclerView의 아이템들을 꾸며주는 역할을 한다.
그 중에서도 유용한 기능이 아이템 간의 divider 역할을 해주는 것이다.


1. ItemDecoration Divider 적용 전  
![ItemDecoration_before](https://user-images.githubusercontent.com/55661741/81265521-30f71680-907e-11ea-9095-71ea431cc3a2.PNG)

2. ItemDecoration Divider 적용 후  
![ItemDecoration_after](https://user-images.githubusercontent.com/55661741/81265545-3fddc900-907e-11ea-8903-10799687a29e.PNG)

3. Constraint Layout에 Border를 다음과 같이 적용하였을때  
android:background="@drawable/item_border"를 item xml에 추가  
![border](https://user-images.githubusercontent.com/55661741/81265561-4704d700-907e-11ea-92df-18d3612cc804.PNG)

# clipToPadding
최상단이나 최하단에 패딩을 줬을 경우 스크롤을 하면 이 영역은 스크롤 영역에 포함되지 않는데
cliptoPadding을 false로 주면 이 영역도 스크롤 영역에 포함되어 스크롤된다.


1. clipToPadding="true"  
![padding_true](https://user-images.githubusercontent.com/55661741/81265612-5dab2e00-907e-11ea-8ecc-d3d5ac36bf24.PNG)

2. cliptoPadding="false"  
![padding_false](https://user-images.githubusercontent.com/55661741/81265651-6e5ba400-907e-11ea-8b80-8cc6ff170dd2.PNG)
