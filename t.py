import pygame as pg
import io
from urllib.request import urlopen
import sys

pg.init()
screen = pg.display.set_mode((1000, 1000))
pg.display.set_caption("나만의 캐릭터 움직이기 게임")

running = True

# 이미지 객체 생성

# 배경화면
background_img_url = "https://img2.daumcdn.net/thumb/R658x0.q70/?fname=https://t1.daumcdn.net/news/202301/16/starnews/20230116071437020xxan.jpg"
background_img_url_str = urlopen(background_img_url).read()
background_img_file = io.BytesIO(background_img_url_str)
#surface 객체
background_img = pg.image.load(background_img_file)
background_img = pg.transform.scale(background_img, (1000, 1000))

# 캐릭터
character_img_url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpNugkDaI0P8NWNCcBfaJ-zicIbehfj7BeBbX-0N-G24L-9c_BDdVbib42expY3mGyh0E&usqp=CAU"
character_img_url_str = urlopen(character_img_url).read()
character_img_file = io.BytesIO(character_img_url_str)
character_img = pg.image.load(character_img_file)
character_img = pg.transform.scale(character_img,(500, 500))

character_img_url1 = "https://res.heraldm.com/content/image/2022/06/11/20220611000054_0.jpg"
character_img_url_str1 = urlopen(character_img_url1).read()
character_img_file1 = io.BytesIO(character_img_url_str1)
character_img1 = pg.image.load(character_img_file1)
character_img1 = pg.transform.scale(character_img1,(500, 500))

# 캐릭터의 사각형 객체(surface의 영역) 반환
character_img_rect = character_img.get_rect()


def handleEvent():
    global character_img_rect
    global running
    for e in pg.event.get():
        if e.type == pg.QUIT:
            running = False
            pg.quit()
            sys.exit()
        if e.type == pg.KEYDOWN:
            if e.key == pg.K_LEFT:
                character_img_rect.x -= 10
            elif e.key == pg.K_RIGHT:
                character_img_rect.x += 10
            elif e.key == pg.K_UP:
                character_img_rect.y -= 10
            elif e.key == pg.K_DOWN:
                character_img_rect.y += 10
        elif e.type == pg.MOUSEBUTTONDOWN:
            if character_img_rect.collidepoint(pg.mouse.get_pos()):
                print("충돌")

def handleEvent1():
    global character_img_rect
    global character_img
    for e in pg.event.get():
        if e.type == pg.QUIT:
            running = False
            pg.quit()
            sys.exit()
        elif e.type == pg.MOUSEBUTTONDOWN:
            if character_img_rect.collidepoint(pg.mouse.get_pos()):
                character_img = character_img1
                character_img_rect = character_img.get_rect()
                font = pg.font.SysFont("malgungothic", 100)
                text_surface = font.render("충돌", True, (10, 10, 10), (20, 20, 20))
                screen.blit(text_surface, (500, 500))
                pg.display.update()
                pg.time.wait(3000)

        pressed = pg.key.get_pressed()
        if pressed[pg.K_UP]:character_img_rect.y -= 10
        if pressed[pg.K_DOWN]:character_img_rect.y += 10
        if pressed[pg.K_RIGHT]: character_img_rect.x += 10
        if pressed[pg.K_LEFT]: character_img_rect.x -= 10
        if pressed[pg.K_ESCAPE]: 
            print("휴식중")
            pg.time.wait(3000)
    

while running:
    screen.blit(background_img, background_img.get_rect())
    #이벤트 처리
    # handleEvent() 
    handleEvent1()
    
    screen.blit(character_img, character_img_rect)
    # img를 rect에 복사
    # 화면에 그리기
    pg.display.update()

pg.quit()
