import pygame as pg
import io
from urllib.request import urlopen
import sys
import random


pg.init()
screen = pg.display.set_mode((1000, 1000))

# 이미지 객체 생성
background_img_url = "https://img2.daumcdn.net/thumb/R658x0.q70/?fname=https://t1.daumcdn.net/news/202301/16/starnews/20230116071437020xxan.jpg"
background_img_url_str = urlopen(background_img_url).read()
background_img_file = io.BytesIO(background_img_url_str)
#surface 객체
background_img = pg.image.load(background_img_file)
background_img = pg.transform.scale(background_img, (1000, 1000))

character_img_url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpNugkDaI0P8NWNCcBfaJ-zicIbehfj7BeBbX-0N-G24L-9c_BDdVbib42expY3mGyh0E&usqp=CAU"
character_img_url_str = urlopen(character_img_url).read()
character_img_file = io.BytesIO(character_img_url_str)
character_img = pg.image.load(character_img_file)
character_img = pg.transform.scale(character_img,(150, 150))
rock = character_img

character_img_url1 = "https://res.heraldm.com/content/image/2022/06/11/20220611000054_0.jpg"
character_img_url_str1 = urlopen(character_img_url1).read()
character_img_file1 = io.BytesIO(character_img_url_str1)
character_img1 = pg.image.load(character_img_file1)
character_img1 = pg.transform.scale(character_img1,(150, 150))
scissors = character_img1

character_img_url2 = "https://thumb.mtstarnews.com/06/2022/06/2022060106324846466_1.jpg/dims/optimize"
character_img_url_str2 = urlopen(character_img_url2).read()
character_img_file2 = io.BytesIO(character_img_url_str2)
character_img2 = pg.image.load(character_img_file2)
character_img2 = pg.transform.scale(character_img2,(150, 150))
paper = character_img2

RSP = [rock ,scissors, paper]

# 컴퓨터가 낼 손을 랜덤으로 결정
random_computer = random.choice(RSP)

# 폰트 객체 생성
font = pg.font.SysFont("nanumbarungothic", 60)

# 승.무.패에 대한 Surface 객체 생성
text_surface_win = font.render("승리!", True, (0, 0, 0), None)
text_surface_lose = font.render("패배...", True, (0, 0, 0), None)
text_surface_tie = font.render("무승부!", True, (0, 0, 0), None)

running = True


while running:
    
    # 화면에 이미지 그리기
    screen.blit(background_img, background_img.get_rect())
    scissors_pos = screen.blit(scissors, (50, 100))
    rock_pos = screen.blit(rock, (200, 100))
    paper_pos = screen.blit(paper, (350, 100))
    
    # 외부 이벤트 감지하기
    for event in pg.event.get():
        if event.type == pg.MOUSEBUTTONDOWN:
        
            # 가위 이미지를 클릭한 경우
            if scissors_pos.collidepoint(pg.mouse.get_pos()):
                screen.blit(background_img, background_img.get_rect())
                
                screen.blit(scissors, (80, 320))
                screen.blit(random_computer, (350, 320))
                
                if random_computer == rock:
                    screen.blit(text_surface_lose, (200, 150))
                elif random_computer == scissors:
                    screen.blit(text_surface_tie, (200, 150))
                else:
                    screen.blit(text_surface_win, (200, 150))
                
                pg.display.update()
                pg.time.wait(3000)
                #running = False
                random_computer = random.choice(RSP)
                
            # 바위 이미지를 클릭한 경우
            elif rock_pos.collidepoint(pg.mouse.get_pos()):
                screen.blit(background_img, background_img.get_rect())
                
                screen.blit(rock, (80, 320))
                screen.blit(random_computer, (350, 320))
                
                if random_computer == rock:
                    screen.blit(text_surface_tie, (200, 150))
                elif random_computer == scissors:
                    screen.blit(text_surface_win, (200, 150))
                else:
                    screen.blit(text_surface_lose, (200, 150))
                
                pg.display.update()
                pg.time.wait(3000)
                #running = False
                random_computer = random.choice(RSP)
                
            # 보 이미지를 클릭한 경우
            elif paper_pos.collidepoint(pg.mouse.get_pos()):
                screen.blit(background_img, background_img.get_rect())
                
                screen.blit(paper, (80, 320))
                screen.blit(random_computer, (350, 320))
                
                if random_computer == rock:
                    screen.blit(text_surface_win, (200, 150))
                elif random_computer == scissors:
                    screen.blit(text_surface_lose, (200, 150))
                else:
                    screen.blit(text_surface_tie, (200, 150))
                
                pg.display.update()
                pg.time.wait(3000)
                #running = False
                random_computer = random.choice(RSP)
                
    pg.display.update()
    
pg.quit()