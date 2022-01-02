package com.danielajayi.shapetap.game;

import com.badlogic.gdx.ApplicationAdapter;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.Preferences;

import com.badlogic.gdx.audio.Music;

import com.badlogic.gdx.graphics.Camera;

import com.badlogic.gdx.graphics.Color;

import com.badlogic.gdx.graphics.GL20;

import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.graphics.PerspectiveCamera;

import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

import com.badlogic.gdx.graphics.g2d.GlyphLayout;

import com.badlogic.gdx.graphics.g2d.Sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;

import com.badlogic.gdx.math.Rectangle;

import com.badlogic.gdx.scenes.scene2d.Event;

import com.badlogic.gdx.scenes.scene2d.EventListener;

import com.badlogic.gdx.scenes.scene2d.Stage;

import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

import com.badlogic.gdx.scenes.scene2d.ui.Label;

import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import com.badlogic.gdx.utils.viewport.ExtendViewport;

import com.badlogic.gdx.utils.viewport.FillViewport;

import com.badlogic.gdx.utils.viewport.FitViewport;

import com.badlogic.gdx.utils.viewport.ScreenViewport;

import com.badlogic.gdx.utils.viewport.StretchViewport;

import com.badlogic.gdx.utils.viewport.Viewport;

import com.badlogic.gdx.ApplicationAdapter.*;

import static com.badlogic.gdx.Gdx.gl;

import java.util.ArrayList;

import java.util.Random;

import sun.rmi.runtime.Log;


public class ShapeTap extends ApplicationAdapter {

    SpriteBatch batch;


    //Splash Screen

    Texture ssIcon;

    Texture ssBg;

    Texture squares;


    //Play Screen

    ImageButton playButton;

    ImageButton gameOverOkButton;

    Texture shapeTapText;

    Texture scoreBox;

    Texture play;

    int ssTimer;

    int ssDuration;

    int gameMode;

    int scoreBoxWidth;


    //Game Screen

    Texture gameBg;


    Texture pinkCircle;

    Texture blueCircle;

    Texture orangeCircle;

    Texture purpleCircle;

    Texture greenCircle;


    Texture pinkTriangle;

    Texture blueTriangle;

    Texture orangeTriangle;

    Texture purpleTriangle;

    Texture greenTriangle;


    Texture pinkSquare;

    Texture blueSquare;

    Texture orangeSquare;

    Texture purpleSquare;

    Texture greenSquare;


    Texture pinkPentagon;

    Texture bluePentagon;

    Texture orangePentagon;

    Texture purplePentagon;

    Texture greenPentagon;


    Texture pinkStar;

    Texture blueStar;

    Texture orangeStar;

    Texture purpleStar;

    Texture greenStar;


    Texture[] shapes;


    Texture pinkSelectionBox;

    Texture blueSelectionBox;

    Texture orangeSelectionBox;

    Texture purpleSelectionBox;

    Texture greenSelectionBox;

    Texture[] selectionBoxes;

    int currentSelectionBox;

    int selectionBoxTimer;
//
//    Rectangle[][] selectionBoxRectangles1;

    ArrayList<Rectangle> selectionBoxRectangles;


    final int SPLASH_SCREEN = 0;

    final int PLAY_SCREEN = 1;

    final int PLAYING = 2;

    final int GAME_OVER = 3;

    int xPositionSquares = 0;

    int[][] xPositionShapes;

    double[][] xScaleOfShapes;

    double[][] yScaleOfShapes;

    double[][] scaleOfShapes;

    double[] widthOfSelectionBoxes;

    int[] numShapesInRow;

    int yPositionSquares = 0;

    int timesToSetToPlayScreen = 0;

    Music gameMusic;

    Music buttonTapSfx;

    boolean buttonTapSfxAlreadyPlayed;

    private Stage stage;

    int score;

    int highScore;

    int shapeYPosition;

    int[] shapeFallSpeed1;

    int[] shapesOnScreen1;

    boolean[][] progenityCreated;

    Preferences prefs;

    int lastScore;

    int screenHeight;

    int screenWidth;

    int clickLoadTimer;

    int[][] shapeYPositions1;

    Texture[][] randomShapes1;

    Rectangle[][] shapesRectangles1;

    int[][] shapeColors;

    double[] shapeScalePerRowCount;

    double[] selectionBoxXPositions;

    ImageButton selectionBoxButton;

    ImageButton selectionBoxButton2;

    ImageButton selectionBoxButton3;

    ImageButton selectionBoxButton4;

    ArrayList<ImageButton> selectionBoxButtons;

    ImageButton boxButton;

    int[] correctTaps1;

    int[] randomNumShape1;


    Random rand;

    boolean gameStart;

    int numRowsOnScreen;

    boolean scored;

    Texture production;

    int scoresUntilSelectionBoxChange;

    GlyphLayout highScoreLayout;

    GlyphLayout scoreLayout;

    boolean oneGamePlayed;

    OrthographicCamera camera;

    Viewport viewport;

    Boolean xGoingDown;

    Texture black;

    Sprite blackSprite;

    float blackOpacity = 0;

    Texture youScoredText;

    Texture okButton;

    FreeTypeFontGenerator generator;

    FreeTypeFontGenerator.FreeTypeFontParameter parameter;

    FreeTypeFontGenerator generatorLight;

    FreeTypeFontGenerator.FreeTypeFontParameter parameterLight;

    BitmapFont font12;

    BitmapFont fontLight;

    Label highScoreLabel;

    int originalFallSpeed;

    boolean shapeOffScreen;

    int gameOverMinTime;

    int gameOverTimerScreenTimer;

    final int PINK = 0;

    final int BLUE = 1;

    final int ORANGE = 2;

    final int GREEN = 3;

    final int PURPLE = 4;

    int waitTimeCreateShape;

    int createShapeTimer;

    boolean clickLoadTimerOn;

    public NotificationHandler notificationHandler;

    boolean oneCorrectBlock;

    int minScoreTwoRows;

    int minScoreThreeRows;

    int minScoreFourRows;

    boolean tapped;

    int wonOrLost;

    double probNextShapeIsColorOfSelectionBox;

    Drawable selectionBox;

    Drawable selectionBox4;

    Drawable selectionBox2;

    Drawable selectionBox3;

    ArrayList<Drawable> selectionBoxDrawables;

    int shapeCreationTimer;

    boolean[] oneAlreadyRemoved;
//
//    ShapeRenderer shapeRenderer;

    static int rowJustTapped;

    //pause menu

    Texture pauseBtnTexture;

    Texture pauseMenu;

    Texture signature;

    Texture resumeBtnTexture;

    Texture homeBtnTexture;

    Texture restartBtnTexture;

    Texture muteSfxBtnTexture;

    Texture muteMusicBtnTexture;

    Texture x;

    ImageButton pauseBtn;

    ImageButton resumeBtn;

    ImageButton homeBtn;

    ImageButton restartBtn;

    ImageButton muteSfxBtn;

    ImageButton muteMusicBtn;

    boolean paused;

    int pauseBtnCooldownTimer;

    boolean musicPlaying;

    boolean sfxPlaying;

    Sprite triangleSpr;

    Sprite squareSpr;

    Sprite ellipseSpr;

    Sprite starSpr;

    Sprite pentagonSpr;

    Sprite selectionBoxSpr;

    ArrayList<Color> colors;

    Color pink;

    Color blue;

    Color orange;

    Color purple;

    Color green;


    @Override

    public void create() {

        Gdx.app.log("Ckeckpoint", "" + 1);

        batch = new SpriteBatch();

        rand = new Random();

        FreeTypeFontGenerator.setMaxTextureSize(4000);

        randomNumShape1 = new int[]{rand.nextInt(25), rand.nextInt(25), rand.nextInt(25), rand.nextInt(25)};


        xPositionShapes = new int[4][30];

        scaleOfShapes = new double[4][30];

        xScaleOfShapes = new double[4][30];

        yScaleOfShapes = new double[4][30];

        wonOrLost = 0;

        pauseBtnCooldownTimer = 50;

        pink = new Color();

        blue = new Color();

        orange = new Color();

        purple = new Color();

        green = new Color();

        pink.add(255f,132f,132f,1);

        blue.add(115f,230f,255f,1);

        orange.add(251f, 154f, 91f,1);

        purple.add(213f,205f,243f,1);

        green.add(110f,227f,135f,1);

        colors = new ArrayList<Color>();

        colors.add(pink);

        colors.add(blue);

        colors.add(orange);

        colors.add(purple);

        colors.add(green);
//
//        triangleSpr = new Sprite(new Texture("triangle.png"));
//
//        squareSpr = new Sprite(new Texture("square.png"));
//
//        starSpr = new Sprite(new Texture("star.png"));
//
//        pentagonSpr = new Sprite(new Texture("pentagon.png"));
//
//        ellipseSpr = new Sprite(new Texture("ellipse.png"));
//
//        selectionBoxSpr = new Sprite(new Texture("selection_box.png"));


        // Images

        ssIcon = new Texture("ss_icon.png");

        ssBg = new Texture("ss_bg.png");

        play = new Texture("play_button.png");

        shapeTapText = new Texture("shape_tap_text.png");

        squares = new Texture("squares.png");

        scoreBox = new Texture("score_box.png");

        production = new Texture("production.png");

        youScoredText = new Texture("you_scored.png");

        okButton = new Texture("ok_button.png");

        black = new Texture("black.png");

        blackOpacity = 0f;

        blackSprite = new Sprite(black);


        //Shapes

        pinkCircle = new Texture("pink_circle.png");

        blueCircle = new Texture("blue_circle.png");

        orangeCircle = new Texture("orange_circle.png");

        purpleCircle = new Texture("purple_circle.png");

        greenCircle = new Texture("green_circle.png");


        pinkTriangle = new Texture("pink_triangle.png");

        blueTriangle = new Texture("blue_triangle.png");

        orangeTriangle = new Texture("orange_triangle.png");

        purpleTriangle = new Texture("purple_triangle.png");

        greenTriangle = new Texture("green_triangle.png");


        pinkSquare = new Texture("pink_square.png");

        blueSquare = new Texture("blue_square.png");

        orangeSquare = new Texture("orange_square.png");

        purpleSquare = new Texture("purple_square.png");

        greenSquare = new Texture("green_square.png");


        pinkPentagon = new Texture("pink_pentagon.png");

        bluePentagon = new Texture("blue_pentagon.png");

        orangePentagon = new Texture("orange_pentagon.png");

        purplePentagon = new Texture("purple_pentagon.png");

        greenPentagon = new Texture("green_pentagon.png");


        pinkStar = new Texture("pink_star.png");

        blueStar = new Texture("blue_star.png");

        orangeStar = new Texture("orange_star.png");

        purpleStar = new Texture("purple_star.png");

        greenStar = new Texture("green_star.png");


        pinkSelectionBox = new Texture("pink_selection_box.png");

        blueSelectionBox = new Texture("blue_selection_box.png");

        orangeSelectionBox = new Texture("orange_selection_box.png");

        purpleSelectionBox = new Texture("purple_selection_box.png");

        greenSelectionBox = new Texture("green_selection_box.png");


        widthOfSelectionBoxes = new double[4];

        widthOfSelectionBoxes[0] = (blueSelectionBox.getHeight() * .8);

        widthOfSelectionBoxes[1] = (blueSelectionBox.getHeight() * .6);

        widthOfSelectionBoxes[2] = (blueSelectionBox.getHeight() * .5);

        widthOfSelectionBoxes[3] = (blueSelectionBox.getHeight() * .4);

        boolean tapped = false;


        shapes = new Texture[25];

        shapes[0] = pinkCircle;

        shapes[1] = blueCircle;

        shapes[2] = orangeCircle;

        shapes[3] = greenCircle;

        shapes[4] = purpleCircle;


        shapes[5] = pinkPentagon;

        shapes[6] = bluePentagon;

        shapes[7] = orangePentagon;

        shapes[8] = greenPentagon;

        shapes[9] = purplePentagon;


        shapes[10] = pinkSquare;

        shapes[11] = blueSquare;

        shapes[12] = orangeSquare;

        shapes[13] = greenSquare;

        shapes[14] = purpleSquare;


        shapes[15] = pinkTriangle;

        shapes[16] = blueTriangle;

        shapes[17] = orangeTriangle;

        shapes[18] = greenTriangle;

        shapes[19] = purpleTriangle;


        shapes[20] = pinkStar;

        shapes[21] = blueStar;

        shapes[22] = orangeStar;

        shapes[23] = greenStar;

        shapes[24] = purpleStar;

        numRowsOnScreen = 1;


        selectionBoxes = new Texture[5];

        selectionBoxes[0] = pinkSelectionBox;

        selectionBoxes[1] = blueSelectionBox;

        selectionBoxes[2] = orangeSelectionBox;

        selectionBoxes[3] = greenSelectionBox;

        selectionBoxes[4] = purpleSelectionBox;

        shapesOnScreen1 = new int[]{1, 1, 1, 1};

        screenWidth = 1080;

        screenHeight = 1794;

        numShapesInRow = new int[]{1, 1, 1, 1};

        progenityCreated = new boolean[4][30];

        for (boolean[] a : progenityCreated) {

            for (boolean b : a) {

                b = false;

            }

        }

        //pause menu

        pauseBtnTexture = new Texture("pause_btn.png");

        pauseMenu = new Texture("pause_btn_menu.png");

        signature = new Texture("pause_menu_signature.png");

        resumeBtnTexture = new Texture("resume_btn.png");

        homeBtnTexture = new Texture("home_btn.png");

        restartBtnTexture = new Texture("restart_btn.png");

        muteSfxBtnTexture = new Texture("sfx_btn.png");

        muteMusicBtnTexture = new Texture("music_btn.png");

        x = new Texture("mute_btn.png");


        Drawable pauseBtnDrawable = new TextureRegionDrawable(new TextureRegion(pauseBtnTexture));

        pauseBtn = new ImageButton(pauseBtnDrawable);

        pauseBtn.setSize((int) (pauseBtn.getWidth() / 2), (int) (pauseBtn.getHeight() / 2));

        pauseBtn.setPosition(screenWidth - 125 - (pauseBtn.getWidth() / 2), (float) (screenHeight) - 180);


        Drawable resumeBtnDrawable = new TextureRegionDrawable(new TextureRegion(resumeBtnTexture));

        resumeBtn = new ImageButton(resumeBtnDrawable);

        resumeBtn.setSize((int) (resumeBtn.getWidth() * .8), (int) (resumeBtn.getHeight() * .8));

        resumeBtn.setPosition(screenWidth / 2 - 400, (float) (screenHeight * .5) - 35);


        Drawable homeBtnDrawable = new TextureRegionDrawable(new TextureRegion(homeBtnTexture));

        homeBtn = new ImageButton(homeBtnDrawable);

        homeBtn.setSize((int) (homeBtn.getWidth() * .8), (int) (homeBtn.getHeight() * .8));

        homeBtn.setPosition(screenWidth / 2 - 180, (float) (screenHeight * .5) - 35);


        Drawable restartBtnDrawable = new TextureRegionDrawable(new TextureRegion(restartBtnTexture));

        restartBtn = new ImageButton(restartBtnDrawable);

        restartBtn.setSize((int) (restartBtn.getWidth() * .8), (int) (restartBtn.getHeight() * .8));

        restartBtn.setPosition(screenWidth / 2 + 20, (float) (screenHeight * .5) - 35);


        Drawable muteMusicBtnDrawable = new TextureRegionDrawable(new TextureRegion(muteMusicBtnTexture));

        muteMusicBtn = new ImageButton(muteMusicBtnDrawable);

        muteMusicBtn.setSize((int) (muteMusicBtn.getWidth() * .8), (int) (muteMusicBtn.getHeight() * .8));

        muteMusicBtn.setPosition(screenWidth / 2 + 260, (float) (screenHeight * .5) - 35);


        Drawable muteSfxBtnDrawable = new TextureRegionDrawable(new TextureRegion(muteSfxBtnTexture));

        muteSfxBtn = new ImageButton(muteSfxBtnDrawable);

        muteSfxBtn.setSize((int) (muteSfxBtn.getWidth() * .8), (int) (muteSfxBtn.getHeight() * .8));

        muteSfxBtn.setPosition(screenWidth / 2 + 270, (float) (screenHeight * .5) + 35);


        correctTaps1 = new int[]{0, 0, 0, 0};

        shapeScalePerRowCount = new double[]{1, .75, .625, .5};

        randomShapes1 = new Texture[4][30];

        randomShapes1[0][0] = shapes[randomNumShape1[0]];

        randomShapes1[1][0] = shapes[randomNumShape1[1]];

        randomShapes1[2][0] = shapes[randomNumShape1[2]];

        randomShapes1[3][0] = shapes[randomNumShape1[3]];

        shapeColors = new int[4][30];

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 5; j++) {

                if (randomNumShape1[i] % 5 == j) {

                    shapeColors[i][0] = j;

//				PINK = 0, BLUE = 1, ORANGE = 2, GREEN = 3, PURPLE = 4

                }

            }

        }

        shapesRectangles1 = new Rectangle[4][30];

        shapeYPositions1 = new int[4][30];

        shapeYPositions1[0][0] = 0;

        shapeYPositions1[1][0] = 0;

        shapeYPositions1[2][0] = 0;

        shapeYPositions1[3][0] = 0;

        selectionBoxRectangles = new ArrayList<Rectangle>();
//
//        selectionBoxRectangles1 = new Rectangle[4][6];


        gameBg = new Texture("game_bg.png");

        clickLoadTimer = 0;

        clickLoadTimerOn = false;

        currentSelectionBox = rand.nextInt(5);


        shapeYPosition = 0;

        shapeFallSpeed1 = new int[]{3, 3, 3, 3};

        oneAlreadyRemoved = new boolean[4];

        oneAlreadyRemoved[0] = false;

        oneAlreadyRemoved[1] = false;

        oneAlreadyRemoved[2] = false;

        oneAlreadyRemoved[3] = false;

        score = 0;

        highScore = 0;

        generator = new FreeTypeFontGenerator(Gdx.files.internal("segoe-ui-bold.ttf"));

        generatorLight = new FreeTypeFontGenerator(Gdx.files.internal("segoe_ui_light.ttf"));

        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        parameterLight = new FreeTypeFontGenerator.FreeTypeFontParameter();

        //fontLight = new BitmapFont();

        //font = TrueTypeFontFactory.createBitmapFont(Gdx.files.internal("segoe-ui-bold.ttf"), FONT_CHARACTERS, 12.5f, 7.5f, 1.0f, screenWidth, screenHeight);

        parameter.size = 500;

        parameterLight.size = 500;

        font12 = generator.generateFont(parameter);

        fontLight = generatorLight.generateFont(parameterLight);

        generator.dispose();

        selectionBoxTimer = 0;


        //Splash Screen

        ssTimer = 0;

        ssDuration = 150;


        //Game Mode

        gameMode = 0;


        originalFallSpeed = 6;


        scoreBoxWidth = 0;


        //Game Music

        gameMusic = Gdx.audio.newMusic(Gdx.files.internal("relaxer2.wav"));

        gameMusic.setVolume(.7f);

        gameMusic.setLooping(true);

        gameMusic.play();

        //buttonTapSfx = Gdx.audio.newMusic(Gdx.files.internal("button_click2.wav"));

        //buttonTapSfx.setVolume(3.0f);

        buttonTapSfxAlreadyPlayed = false;

        Drawable playButtonDrawable = new TextureRegionDrawable(new TextureRegion(play));

        playButton = new ImageButton(playButtonDrawable);

        playButton.setSize((int) (play.getWidth() * .8), (int) (play.getHeight() * .8));

        playButton.setPosition(((screenWidth / 2) - (int) (playButton.getWidth() * .8 / 2)), (int) (screenHeight / 3));

//
//        shapeRenderer = new ShapeRenderer();

        Drawable OkButtonDrawable = new TextureRegionDrawable(new TextureRegion(okButton));

        gameOverOkButton = new ImageButton(OkButtonDrawable);

        gameOverOkButton.setSize((int) (okButton.getWidth() / 1.3), (int) (okButton.getHeight() / 1.3));

        gameOverOkButton.setPosition(screenWidth / 2 - (int) (okButton.getWidth() / 1.3 / 2), screenHeight / 3);

        selectionBoxXPositions = new double[4];

        selectionBoxXPositions[0] = screenWidth / 2 - (int) (blueSelectionBox.getWidth() * .4);

        selectionBoxXPositions[1] = screenWidth - (screenWidth - (int) (blueSelectionBox.getWidth() * .6 * 2)) / 3 - (int) (blueSelectionBox.getWidth() * .6);

        selectionBoxXPositions[2] = screenWidth - (screenWidth - (int) (blueSelectionBox.getWidth() * .5 * 3)) / 4 - (int) (blueSelectionBox.getWidth() * .5);

        selectionBoxXPositions[3] = 4 * (screenWidth - (int) (blueSelectionBox.getWidth() * .4 * 4)) / 5 + (int) (3 * blueSelectionBox.getWidth() * .4);

        selectionBox = new TextureRegionDrawable(new TextureRegion(selectionBoxes[currentSelectionBox]));

        selectionBoxButton = new ImageButton(selectionBox);

        //batch.draw(selectionBoxes[currentSelectionBox],screenWidth / 2 - (int)(blueSelectionBox.getWidth() * .4),(int)(screenHeight * .05), (int)(blueSelectionBox.getHeight() * .8), (int)(blueSelectionBox.getWidth() * .8));

        selectionBoxButton.setSize((int) (blueSelectionBox.getHeight() * .8), (int) (blueSelectionBox.getWidth() * .8));

        selectionBoxButton.setPosition((int)selectionBoxXPositions[0], (int) (screenHeight * .05));

        selectionBox2 = new TextureRegionDrawable(new TextureRegion(selectionBoxes[currentSelectionBox]));

        selectionBoxButton2 = new ImageButton(selectionBox2);

        //batch.draw(selectionBoxes[currentSelectionBox], screenWidth - (screenWidth - (int)(blueSelectionBox.getWidth() * .6 * 2)) / 3 - (int)(blueSelectionBox.getWidth() * .6), (int)(screenHeight * .05), (int)(blueSelectionBox.getHeight() * .6), (int)(blueSelectionBox.getWidth() * .6));

        selectionBoxButton2.setSize((int) (blueSelectionBox.getHeight() * .6), (int) (blueSelectionBox.getWidth() * .6));

        selectionBoxButton2.setPosition((int)(selectionBoxXPositions[1]), (int) (screenHeight * .05));


//         batch.draw(selectionBoxes[currentSelectionBox], (screenWidth - (int) (blueSelectionBox.getWidth() * .6 * 2)) / 3, (int) (screenHeight * .05), (int) (blueSelectionBox.getHeight() * .6), (int) (blueSelectionBox.getWidth() * .6));
//
//                batch.draw(selectionBoxes[currentSelectionBox], screenWidth - (screenWidth - (int) (blueSelectionBox.getWidth() * .6 * 2)) / 3 - (int) (blueSelectionBox.getWidth() * .6), (int) (screenHeight * .05), (int) (blueSelectionBox.getHeight() * .6), (int) (blueSelectionBox.getWidth() * .6));

        selectionBox3 = new TextureRegionDrawable(new TextureRegion(selectionBoxes[currentSelectionBox]));

        selectionBoxButton3 = new ImageButton(selectionBox3);

//		batch.draw(selectionBoxes[currentSelectionBox], screenWidth - (screenWidth - (int)(blueSelectionBox.getWidth() * .5 * 3)) / 4 - (int)(blueSelectionBox.getWidth() * .5), (int)(screenHeight * .05), (int)(blueSelectionBox.getHeight() * .5), (int)(blueSelectionBox.getWidth() * .5));

        selectionBoxButton3.setSize((int) (blueSelectionBox.getHeight() * .5), (int) (blueSelectionBox.getWidth() * .5));

        selectionBoxButton3.setPosition((int)(selectionBoxXPositions[2]), (int) (screenHeight * .05));


        selectionBox4 = new TextureRegionDrawable(new TextureRegion(selectionBoxes[currentSelectionBox]));

        selectionBoxButton4 = new ImageButton(selectionBox4);

        selectionBoxButton4.setSize((int) (blueSelectionBox.getHeight() * .4), (int) (blueSelectionBox.getWidth() * .4));

        //batch.draw(selectionBoxes[currentSelectionBox], 4 * (screenWidth - (int)(blueSelectionBox.getWidth() * .4 * 4)) / 5 + (int)(3 * blueSelectionBox.getWidth() * .4), (int)(screenHeight * .05), (int)(blueSelectionBox.getHeight() * .4), (int)(blueSelectionBox.getWidth() * .4));

        selectionBoxButton4.setPosition((int)(selectionBoxXPositions[3]), (int) (screenHeight * .05));

        selectionBoxDrawables = new ArrayList <Drawable>();

        selectionBoxDrawables.add(selectionBox);

        selectionBoxDrawables.add(selectionBox2);

        selectionBoxDrawables.add(selectionBox3);

        selectionBoxDrawables.add(selectionBox4);

        selectionBoxButtons = new ArrayList <ImageButton>();

        selectionBoxButtons.add(null);

        selectionBoxButtons.add(null);

        selectionBoxButtons.add(null);

        selectionBoxButtons.add(null);

        selectionBoxButtons.set(0, selectionBoxButton);

        selectionBoxButtons.set(1, selectionBoxButton2);

        selectionBoxButtons.set(2, selectionBoxButton3);

        selectionBoxButtons.set(3, selectionBoxButton4);

        xGoingDown = false;

        gameStart = false;

        scored = false;

        scoresUntilSelectionBoxChange = rand.nextInt(10) + 5;

        scoresUntilSelectionBoxChange = 2;

        prefs = Gdx.app.getPreferences("My Preferences");

        highScore = prefs.getInteger("high score", 0);

        highScoreLayout = new GlyphLayout();

        scoreLayout = new GlyphLayout();

        lastScore = 0;

        oneGamePlayed = false;

        camera = new OrthographicCamera();

        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);

        //viewport = new ExtendViewport(1080 / 2,1794 / 2, camera);

        viewport = new StretchViewport(1080, 1794, camera);

        //viewport = new ScreenViewport(camera);

        stage = new Stage(viewport, batch);

        stage.setViewport(viewport);

        stage.getViewport().update(screenWidth, screenHeight);

        stage.addActor(playButton);

        stage.addActor(gameOverOkButton);

        stage.addActor(pauseBtn);

        stage.addActor(muteMusicBtn);

        stage.addActor(muteSfxBtn);

        stage.addActor(homeBtn);

        stage.addActor(restartBtn);

        stage.addActor(resumeBtn);

        stage.addActor(selectionBoxButton);

        stage.addActor(selectionBoxButton2);

        stage.addActor(selectionBoxButton3);

        stage.addActor(selectionBoxButton4);

        paused = false;


        Gdx.input.setInputProcessor(stage);

        viewport.apply();

        stage.getViewport().apply();

        stage.act();


        //Create high score text

        fontLight.getData().setScale(.10f);

        //font12.getData().setScale(.10f);

        highScoreLayout = new GlyphLayout(fontLight, "High Score: " + highScore);

        scoreLayout = new GlyphLayout(fontLight, "Score: " + lastScore);

        highScoreLabel = new Label("High Score: " + highScore, new Label.LabelStyle(fontLight, Color.WHITE));

        highScoreLabel.setPosition((screenWidth / 2) - (highScoreLayout.width / 2), (int) (screenHeight / 2 + 35));

        stage.addActor(highScoreLabel);

        fontLight.getData().setScale(.10f);

        shapeOffScreen = false;


        gameOverMinTime = 75;

        gameOverTimerScreenTimer = 0;

        waitTimeCreateShape = 5;

        createShapeTimer = 0;

        oneCorrectBlock = false;


        minScoreTwoRows = 10;

        minScoreThreeRows = 20;

        minScoreFourRows = 30;

        probNextShapeIsColorOfSelectionBox = .4;

        rowJustTapped = 0;

        musicPlaying = true;

        sfxPlaying = true;



    }


//	void matchingBlock() {
//
//
//
//	}

    @Override

    public void render() {


        camera.update();

        stage.getCamera().update();

        gl.glClearColor(0, 1, 3, 1);

        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        playButton.setVisible(false);

        for (ImageButton i : selectionBoxButtons) {

            i.setVisible(false);

        }

        gameOverOkButton.setVisible(false);

        pauseBtn.setVisible(false);

        muteMusicBtn.setVisible(false);

        muteSfxBtn.setVisible(false);

        homeBtn.setVisible(false);

        restartBtn.setVisible(false);

        resumeBtn.setVisible(false);

        highScoreLabel.setVisible(false);

        batch.setProjectionMatrix(camera.combined);

        //batch.setColor(Color.RED);

        stage.getBatch().setProjectionMatrix(camera.combined);
//
//        shapeRenderer.setProjectionMatrix(camera.combined);

        batch.begin();

        stage.act(Gdx.graphics.getDeltaTime());
//
//        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//
//        shapeRenderer.setColor(Color.RED);


        //notificationHandler.showNotification("asdf","asdf");


        // Splash Screen

        if (ssTimer < ssDuration && gameMode == SPLASH_SCREEN) {

            batch.draw(ssBg, 0, 0, 1080, 1794);

            batch.draw(squares, (int) (0 - screenWidth / 1.5 + xPositionSquares), (int) (0 - screenHeight / 1.5 + yPositionSquares), (int) (squares.getWidth() * .8), (int) (squares.getHeight() * .8));

            batch.draw(ssIcon, screenWidth / 2 - ssIcon.getWidth() / 2, screenHeight / 2 - ssIcon.getHeight() / 2);

            batch.draw(production, screenWidth / 2 - (int) (production.getWidth() * .4), (int) (screenHeight * .1), (int) (production.getWidth() * .8), (int) (production.getHeight() * .8));

            //xPositionSquares++;

            //yPositionSquares--;

            if (xPositionSquares >= -780 && xGoingDown) {

                xPositionSquares -= 1;

                yPositionSquares += 1;

            } else {

                xPositionSquares += 1;

                yPositionSquares -= 1;

                xGoingDown = false;

                if (xPositionSquares >= 0) {

                    xGoingDown = true;

                }

            }

            ssTimer++;


        } else if (ssTimer >= ssDuration && gameMode == SPLASH_SCREEN) {

            gameMode = PLAY_SCREEN;

        }


        // Play Button Screen

        if (gameMode == PLAY_SCREEN) {

            // Draw background and squares

            batch.draw(ssBg, 0, 0, screenWidth, screenHeight);

            batch.draw(squares, (int) (0 - screenWidth / 1.5 + xPositionSquares), (int) (0 - screenHeight / 1.5 + yPositionSquares), (int) (squares.getHeight() * .8), (int) (squares.getWidth() * .8));


            //Give squares movement

            if (xPositionSquares >= -780 && xGoingDown) {

                xPositionSquares -= 1;

                yPositionSquares += 1;

            } else {

                xPositionSquares += 1;

                yPositionSquares -= 1;

                xGoingDown = false;

                if (xPositionSquares >= 0) {

                    xGoingDown = true;

                }

            }

            //Shape Tap Logo on top of screen

            batch.draw(shapeTapText, screenWidth / 2 - ((int) (shapeTapText.getWidth() * .8) / 2), (int) (screenHeight / 1.25), (int) (shapeTapText.getWidth() * .8), (int) (shapeTapText.getHeight() * .8));


            //Create score text

            if (oneGamePlayed) {

                scoreLayout.reset();

                scoreLayout.setText(fontLight, "Score: " + lastScore);

                batch.draw(scoreBox, screenWidth / 2 - (int) ((int) (scoreLayout.width + 54) / 2), screenHeight / 3 + (scoreBox.getHeight() * 3) + (int) (highScoreLayout.height * 2.5) + 20, (int) (scoreLayout.width + 54), 90);

                fontLight.draw(batch, "Score: " + lastScore, (screenWidth / 2) - (scoreLayout.width / 2), (int) (screenHeight / 2 + highScoreLayout.height * 2.2) + 20 + (int) (scoreLayout.height * 2.5));


            }

            //Display High Score Box

            batch.draw(scoreBox, screenWidth / 2 - (int) ((int) (highScoreLayout.width + 54) * .5), screenHeight / 3 + (scoreBox.getHeight() * 3) + 10, (int) (highScoreLayout.width + 54), 90);

            //Gdx.app.log("Height of box",(int)(highScoreLayout.height * 2.5) + "");

            //Display Score Box

            if (oneGamePlayed) {

//                batch.draw(scoreBox, screenWidth / 2 - (int) ((int) (scoreLayout.width + 54) / 2), screenHeight / 3 + (scoreBox.getHeight() * 3) + (int) (highScoreLayout.height * 2.5) + 20, (int) (scoreLayout.width + 54), 90);
//
//                fontLight.draw(batch, "Score: " + lastScore, (screenWidth / 2) - (scoreLayout.width / 2), (int) (screenHeight / 2 + highScoreLayout.height * 2.2) + 20 + (int) (scoreLayout.height * 2.5));

            }

            //Display High Score text


            //fontLight.draw(batch, "High Score: " + highScore, (screenWidth / 2) - (highScoreLayout.width / 2), (int)(screenHeight / 2 + highScoreLayout.height * 2.2) + 10);

            highScoreLabel.setVisible(true);

            playButton.setVisible(true);

            gameOverOkButton.setVisible(false);

            playButton.addListener(new EventListener() {

                @Override

                public boolean handle(Event event) {

                    //notificationHandler.showNotification("asdf","asdf");
//
//                    if (!buttonTapSfx.isPlaying() && !buttonTapSfxAlreadyPlayed) {

//                        buttonTapSfx.play();

//                        buttonTapSfxAlreadyPlayed = true;
//
//                    }

                    highScoreLabel.setVisible(false);

                    playButton.setVisible(false);

                    //Gdx.app.log("play button","clicked");

                    gameMode = PLAYING;

                    return false;

                }

            });

        }

        // Game Started

        if (gameMode == PLAYING) {

            buttonTapSfxAlreadyPlayed = false;

            highScoreLabel.setVisible(false);

            //Draw backgrounds

            batch.draw(ssBg, 0, 0, screenWidth, screenHeight);

            batch.draw(gameBg, 0, 0, screenWidth, screenHeight);

            if (score < minScoreTwoRows) {

                numRowsOnScreen = 1;

            } else if (score < minScoreThreeRows) {

                numRowsOnScreen = 2;

            } else if (score < minScoreFourRows) {

                numRowsOnScreen = 3;

            } else {

                numRowsOnScreen = 4;

            }


//            for (int i = 0; i < numRowsOnScreen; i++) {
//
//                //change the color of the selection box occasionally
//
//                if (correctTaps1[i] % scoresUntilSelectionBoxChange == 0 && correctTaps1[i] != 0) {
////
////                        currentSelectionBox = rand.nextInt(5);
//                    currentSelectionBox = rand.nextInt(5);
////
////                        scoresUntilSelectionBoxChange = rand.nextInt(6) + 5;
//
//                    scoresUntilSelectionBoxChange = 2;
//
//                }
//
//            }

            if (numRowsOnScreen == 1) {

            } else if (numRowsOnScreen == 2) {

                selectionBoxXPositions[0] = (screenWidth - (int) (blueSelectionBox.getWidth() * .6 * 2)) / 3;

            } else if (numRowsOnScreen == 3) {

                selectionBoxXPositions[0] = (screenWidth - (int) (blueSelectionBox.getWidth() * .5 * 3)) / 4;

                selectionBoxXPositions[1] = screenWidth / 2 - (int) (blueSelectionBox.getWidth() * .25);

            } else if (numRowsOnScreen == 4) {

                selectionBoxXPositions[0] = (screenWidth - (int) (blueSelectionBox.getWidth() * .4 * 4)) / 5;

                selectionBoxXPositions[1] = 2 * (screenWidth - (int) (blueSelectionBox.getWidth() * .4 * 4)) / 5 + (int) (blueSelectionBox.getWidth() * .4);

                selectionBoxXPositions[2] = 3 * (screenWidth - (int) (blueSelectionBox.getWidth() * .4 * 4)) / 5 + (int) (2 * blueSelectionBox.getWidth() * .4);

            }

            //Draw selection boxes

            selectionBoxRectangles.clear();

            for (int i = 0; i < numRowsOnScreen; i++) {

                selectionBoxDrawables.set(i, new TextureRegionDrawable(new TextureRegion(selectionBoxes[currentSelectionBox])));

                selectionBoxButtons.set(i, new ImageButton(selectionBoxDrawables.get(i)));

                selectionBoxButtons.get(i).setSize((int)widthOfSelectionBoxes[numRowsOnScreen - 1], (int)widthOfSelectionBoxes[numRowsOnScreen - 1]);

                selectionBoxButtons.get(i).setPosition((int)selectionBoxXPositions[i], (int)(screenHeight * .05));

                //shapeRenderer.rect((int)selectionBoxXPositions[i], (int)(screenHeight * .05), (int)(widthOfSelectionBoxes[numRowsOnScreen - 1] * .5), (int)(widthOfSelectionBoxes[numRowsOnScreen - 1] * .5));

                selectionBoxButtons.get(i).removeActor(selectionBoxButtons.get(i));

                stage.addActor(selectionBoxButtons.get(i));

                selectionBoxButtons.get(i).setVisible(true);

                batch.setColor(colors.get(currentSelectionBox));

                selectionBoxButtons.get(i).draw(batch,1);

                batch.setColor(Color.WHITE);

                selectionBoxRectangles.add(new Rectangle((int)selectionBoxXPositions[i], (int) (screenHeight * .05), (int)widthOfSelectionBoxes[numRowsOnScreen - 1], (int)widthOfSelectionBoxes[numRowsOnScreen - 1]));

            }

//            if (score < minScoreTwoRows) { // one selection box and rect
//
//
//                selectionBoxButtons.get(0).setSize((int)(blueSelectionBox.getHeight() * .8), (int) (blueSelectionBox.getWidth() * .8));
//
//                selectionBoxButtons.get(0).setPosition((int)selectionBoxXPositions[0], (int) (screenHeight * .05));
//
//                selectionBox = new TextureRegionDrawable(new TextureRegion(selectionBoxes[currentSelectionBox]));
//
//                selectionBoxButtons.set(0, new ImageButton(selectionBox));
//
//                selectionBoxButtons.get(0).setSize((int)(blueSelectionBox.getHeight() * .8), (int)(blueSelectionBox.getWidth() * .8));
//
//                selectionBoxButtons.get(0).setPosition((int)selectionBoxXPositions[0], (int)(screenHeight * .05));
//
//                selectionBoxButtons.get(0).removeActor(selectionBoxButtons.get(0));
//
//                stage.addActor(selectionBoxButtons.get(0));
//
//                selectionBoxButtons.get(0).setVisible(true);
//
//                selectionBoxButtons.get(0).draw(batch,1);
//
//
//
//
//                selectionBox = new TextureRegionDrawable(new TextureRegion(selectionBoxes[currentSelectionBox]));
//
//                selectionBoxButton = new ImageButton(selectionBox);
//
//                selectionBoxButton.setSize((int) (blueSelectionBox.getHeight() * .8), (int) (blueSelectionBox.getWidth() * .8));
//
//                selectionBoxButton.setPosition((int)selectionBoxXPositions[0], (int) (screenHeight * .05));
//
//                selectionBoxButton.removeActor(selectionBoxButton);
//
//                stage.addActor(selectionBoxButton);
//
//                selectionBoxButton.setVisible(true);
//
//                selectionBoxButton.draw(batch,1);
//
//                selectionBoxRectangles.clear();
//
//                selectionBoxRectangles.add(new Rectangle((int)selectionBoxXPositions[0], (int) (screenHeight * .05), (int) (blueSelectionBox.getHeight() * .8), (int) (blueSelectionBox.getWidth() * .8)));
//
//                selectionBoxButtons.set(0, selectionBoxButton);
//
//            } else if (score < minScoreThreeRows) { // 2 Selection Boxes and rects
//
//                selectionBoxXPositions[0] = (screenWidth - (int) (blueSelectionBox.getWidth() * .6 * 2)) / 3;
//
//                selectionBoxButton.setPosition((int)selectionBoxXPositions[0], (int) (screenHeight * .05));
//
//                selectionBoxButton.setSize((int) (blueSelectionBox.getHeight() * .6), (int) (blueSelectionBox.getWidth() * .6));
//
//                selectionBoxButton2.draw(batch,1);
//
//                selectionBoxButton.setVisible(true);
//
//                selectionBoxButton2.setVisible(true);
//
//                selectionBoxButtons.set(0, selectionBoxButton);
//
//                selectionBoxButtons.set(1, selectionBoxButton2);
//
//                selectionBoxRectangles.clear();
//
//                //Rectangles
//
//                selectionBoxRectangles.add(new Rectangle((int)selectionBoxXPositions[0], (int) (screenHeight * .05), (int) (blueSelectionBox.getHeight() * .6), (int) (blueSelectionBox.getWidth() * .6)));
//
//                selectionBoxRectangles.add(new Rectangle((int)selectionBoxXPositions[1], (int) (screenHeight * .05), (int) (blueSelectionBox.getHeight() * .6), (int) (blueSelectionBox.getWidth() * .6)));
//
//
//            } else if (score < minScoreFourRows) { // 3 Selection Boxes and rects
//
//                selectionBoxXPositions[0] = (screenWidth - (int) (blueSelectionBox.getWidth() * .5 * 3)) / 4;
//
//                selectionBoxButton.setPosition((int)selectionBoxXPositions[0], (int) (screenHeight * .05));
//
//                selectionBoxButton.setSize((int) (blueSelectionBox.getHeight() * .5), (int) (blueSelectionBox.getWidth() * .5));
//
//                selectionBoxXPositions[1] = screenWidth / 2 - (int) (blueSelectionBox.getWidth() * .25);
//
//                selectionBoxButton2.setPosition((int)selectionBoxXPositions[1], (int) (screenHeight * .05));
//
//                selectionBoxButton2.setSize((int) (blueSelectionBox.getHeight() * .5), (int) (blueSelectionBox.getWidth() * .5));
//
//                selectionBoxButton2.draw(batch,1);
//
//                selectionBoxButton3.draw(batch,1);
//
//                selectionBoxButton.setVisible(true);
//
//                selectionBoxButton2.setVisible(true);
//
//                selectionBoxButton3.setVisible(true);
//
//                selectionBoxButtons.set(0, selectionBoxButton);
//
//                selectionBoxButtons.set(1, selectionBoxButton2);
//
//                selectionBoxButtons.set(2, selectionBoxButton3);
//
//                selectionBoxRectangles.clear();
//
//                //Rectangles
//
//                selectionBoxRectangles.add(new Rectangle((int)selectionBoxXPositions[0], (int) (screenHeight * .05), (int) (blueSelectionBox.getHeight() * .5), (int) (blueSelectionBox.getWidth() * .5)));
//
//                selectionBoxRectangles.add(new Rectangle((int)selectionBoxXPositions[1], (int) (screenHeight * .05), (int) (blueSelectionBox.getHeight() * .5), (int) (blueSelectionBox.getWidth() * .5)));
//
//                selectionBoxRectangles.add(new Rectangle((int)selectionBoxXPositions[2], (int) (screenHeight * .05), (int) (blueSelectionBox.getHeight() * .5), (int) (blueSelectionBox.getWidth() * .5)));
//
//
//            } else { // 4 rows of Selection Boxes
//
//                selectionBoxXPositions[0] = (screenWidth - (int) (blueSelectionBox.getWidth() * .4 * 4)) / 5;
//
//                selectionBoxButton.setPosition((int) selectionBoxXPositions[0], (int) (screenHeight * .05));
//
//                selectionBoxButton.setSize((int) (blueSelectionBox.getHeight() * .4), (int) (blueSelectionBox.getWidth() * .4));
//
//                selectionBoxXPositions[1] = 2 * (screenWidth - (int) (blueSelectionBox.getWidth() * .4 * 4)) / 5 + (int) (blueSelectionBox.getWidth() * .4);
//
//                selectionBoxButton2.setPosition((int) selectionBoxXPositions[1], (int) (screenHeight * .05));
//
//                selectionBoxButton2.setSize((int) (blueSelectionBox.getHeight() * .4), (int) (blueSelectionBox.getWidth() * .4));
//
//                selectionBoxXPositions[2] = 3 * (screenWidth - (int) (blueSelectionBox.getWidth() * .4 * 4)) / 5 + (int) (2 * blueSelectionBox.getWidth() * .4);
//
//                selectionBoxButton3.setPosition((int) selectionBoxXPositions[2], (int) (screenHeight * .05));
//
//                selectionBoxButton3.setSize((int) (blueSelectionBox.getHeight() * .4), (int) (blueSelectionBox.getWidth() * .4));
//
//                selectionBoxButton2.draw(batch,1);
//
//                selectionBoxButton3.draw(batch,1);
//
//                selectionBoxButton4.draw(batch,1);
//
//                selectionBoxButton.setVisible(true);
//
//                selectionBoxButton2.setVisible(true);
//
//                selectionBoxButton3.setVisible(true);
//
//                selectionBoxButton4.setVisible(true);
//
//                selectionBoxButtons.set(0, selectionBoxButton);
//
//                selectionBoxButtons.set(1, selectionBoxButton2);
//
//                selectionBoxButtons.set(2, selectionBoxButton3);
//
//                selectionBoxButtons.set(3, selectionBoxButton4);
//
//                selectionBoxRectangles.clear();
//
//                 //Rectangles
//
//                selectionBoxRectangles.add(new Rectangle((int) selectionBoxXPositions[0], (int) (screenHeight * .05), (int) (blueSelectionBox.getHeight() * .4), (int) (blueSelectionBox.getWidth() * .4)));
//
//                selectionBoxRectangles.add(new Rectangle((int) selectionBoxXPositions[1], (int) (screenHeight * .05), (int) (blueSelectionBox.getHeight() * .4), (int) (blueSelectionBox.getWidth() * .4)));
//
//                selectionBoxRectangles.add(new Rectangle((int) selectionBoxXPositions[2], (int) (screenHeight * .05), (int) (blueSelectionBox.getHeight() * .4), (int) (blueSelectionBox.getWidth() * .4)));
//
//                selectionBoxRectangles.add(new Rectangle((int) selectionBoxXPositions[3], (int) (screenHeight * .05), (int) (blueSelectionBox.getHeight() * .4), (int) (blueSelectionBox.getWidth() * .4)));
//
//            }


            shapesRectangles1 = new Rectangle[4][30];

            for (int i = 0; i < numRowsOnScreen; i++) {

                for (int j = 0; j < shapesOnScreen1[i]; j++) {

                    scaleOfShapes[i][j] = randomShapes1[i][j].getWidth() * shapeScalePerRowCount[numRowsOnScreen - 1];

                    xScaleOfShapes[i][j] = randomShapes1[i][j].getWidth() * shapeScalePerRowCount[numRowsOnScreen - 1];

                    yScaleOfShapes[i][j] = randomShapes1[i][j].getHeight() * shapeScalePerRowCount[numRowsOnScreen - 1];

                    xPositionShapes[i][j] = (int)((selectionBoxXPositions[i] + (widthOfSelectionBoxes[numRowsOnScreen - 1] - xScaleOfShapes[i][j]) * .5));

                }

            }

            //Check for a tap on a selection box

            //Gdx.app.log("Paused state",""+paused);
            if (!paused) {

                selectionBoxButtons.get(0).addListener(new EventListener() {

                    @Override

                    public boolean handle(Event event) {

                        //  Gdx.app.log("Row just tapped", 1 + "");

                        for (int j = shapesOnScreen1[0] - 1; j >= 0; j--) {

                            rowJustTapped = 1;

                            //If the tapped selection box and any shape on the screen are the same color and overlap,

                            if (Intersector.overlaps(shapesRectangles1[0][j], selectionBoxRectangles.get(0)) && currentSelectionBox == shapeColors[0][j] && !paused) {

//                                    if (!buttonTapSfx.isPlaying() && !buttonTapSfxAlreadyPlayed) {
//
////                                        buttonTapSfx.play();
//
//                                        buttonTapSfxAlreadyPlayed = true;
//
//                                    }

                                oneAlreadyRemoved[0] = true;

                                wonOrLost = 2;

                                clickLoadTimerOn = true;

                                //Gdx.app.log("you scored", "1 point");

                                score++;

                                correctTaps1[0]++;

                                scored = true;

                                shapesOnScreen1[0]--;

                                for (int k = j; k <= shapesOnScreen1[0]; k++) {

                                    randomShapes1[0][k] = randomShapes1[0][k + 1];

                                    shapesRectangles1[0][k] = shapesRectangles1[0][k + 1];

                                    shapeColors[0][k] = shapeColors[0][k + 1];

                                    xPositionShapes[0][k] = xPositionShapes[0][k + 1];

                                    shapeYPositions1[0][k] = shapeYPositions1[0][k + 1];

                                    scaleOfShapes[0][k] = scaleOfShapes[0][k + 1];

                                    xScaleOfShapes[0][k] = xScaleOfShapes[0][k + 1];

                                    yScaleOfShapes[0][k] = yScaleOfShapes[0][k + 1];

                                    progenityCreated[0][k] = progenityCreated[0][k + 1];

                                }


                                //shapeColor.remove(i);

                                oneCorrectBlock = true;

                                tapped = true;

                            }

                            buttonTapSfxAlreadyPlayed = false;
//
//                                if (j < 0) {
//
//                                    Gdx.app.log("So this", "is the issue");
//                                    break;
//
//                                }

                        }

                        if (wonOrLost != 2 && !paused) {

                            wonOrLost = 1;

                        }

                        oneAlreadyRemoved[0] = false;

                        return false;

                    }

                });

            }

            if (numRowsOnScreen >= 2 && !paused) {

                selectionBoxButtons.get(1).addListener(new EventListener() {

                    @Override

                    public boolean handle(Event event) {

                        //Gdx.app.log("Row just tapped", 2 + "");

                        for (int j = shapesOnScreen1[1] - 1; j >= 0; j--) {

                            rowJustTapped = 2;

                            //If the tapped selection box and any shape on the screen are the same color and overlap,

                            if (Intersector.overlaps(shapesRectangles1[1][j], selectionBoxRectangles.get(1)) && currentSelectionBox == shapeColors[1][j] && !paused) {

//                                    if (!buttonTapSfx.isPlaying() && !buttonTapSfxAlreadyPlayed) {
//
////                                        buttonTapSfx.play();
//
//                                        buttonTapSfxAlreadyPlayed = true;
//
//                                    }

                                oneAlreadyRemoved[1] = true;

                                wonOrLost = 2;

                                clickLoadTimerOn = true;

                                //Gdx.app.log("you scored", "1 point");

                                score++;

                                correctTaps1[1]++;

                                scored = true;

                                shapesOnScreen1[1]--;

                                for (int k = j; k <= shapesOnScreen1[1]; k++) {

                                    randomShapes1[1][k] = randomShapes1[1][k + 1];

                                    shapesRectangles1[1][k] = shapesRectangles1[1][k + 1];

                                    shapeColors[1][k] = shapeColors[1][k + 1];

                                    xPositionShapes[1][k] = xPositionShapes[1][k + 1];

                                    shapeYPositions1[1][k] = shapeYPositions1[1][k + 1];

                                    scaleOfShapes[1][k] = scaleOfShapes[1][k + 1];

                                    xScaleOfShapes[1][k] = xScaleOfShapes[1][k + 1];

                                    yScaleOfShapes[1][k] = yScaleOfShapes[1][k + 1];

                                    progenityCreated[1][k] = progenityCreated[1][k + 1];

                                }


                                //shapeColor.remove(i);

                                oneCorrectBlock = true;

                                tapped = true;

                            }

                            buttonTapSfxAlreadyPlayed = false;
//
//                                if (j < 0) {
//
//                                    Gdx.app.log("So this", "is the issue");
//                                    break;
//
//                                }

                        }

                        if (wonOrLost != 2 && !paused) {

                            wonOrLost = 1;

                        }

                        oneAlreadyRemoved[1] = false;

                        return false;

                    }

                });
            }

            if (numRowsOnScreen >= 3 && !paused) {

                selectionBoxButtons.get(2).addListener(new EventListener() {

                    @Override

                    public boolean handle(Event event) {

                        rowJustTapped = 3;

                        //Gdx.app.log("Row just tapped", 3 + "");

                        for (int j = shapesOnScreen1[2] - 1; j >= 0; j--) {

                            //If the tapped selection box and any shape on the screen are the same color and overlap,

                            if (Intersector.overlaps(shapesRectangles1[2][j], selectionBoxRectangles.get(2)) && currentSelectionBox == shapeColors[2][j] && !paused) {

//                                        if (!buttonTapSfx.isPlaying() && !buttonTapSfxAlreadyPlayed) {
//
////                                            buttonTapSfx.play();
//
//                                            buttonTapSfxAlreadyPlayed = true;
//
//                                        }

                                oneAlreadyRemoved[2] = true;

                                wonOrLost = 2;

                                clickLoadTimerOn = true;

                                //Gdx.app.log("you scored", "1 point");

                                score++;

                                correctTaps1[2]++;

                                scored = true;

                                shapesOnScreen1[2]--;

                                for (int k = j; k <= shapesOnScreen1[2]; k++) {

                                    randomShapes1[2][k] = randomShapes1[2][k + 1];

                                    shapesRectangles1[2][k] = shapesRectangles1[2][k + 1];

                                    shapeColors[2][k] = shapeColors[2][k + 1];

                                    xPositionShapes[2][k] = xPositionShapes[2][k + 1];

                                    shapeYPositions1[2][k] = shapeYPositions1[2][k + 1];

                                    scaleOfShapes[2][k] = scaleOfShapes[2][k + 1];

                                    xScaleOfShapes[2][k] = xScaleOfShapes[2][k + 1];

                                    yScaleOfShapes[2][k] = yScaleOfShapes[2][k + 1];

                                    progenityCreated[2][k] = progenityCreated[2][k + 1];

                                }


                                //shapeColor.remove(i);

                                oneCorrectBlock = true;

                                tapped = true;

                            }

                            buttonTapSfxAlreadyPlayed = false;
//
//                                if (j < 0) {
//
//                                    Gdx.app.log("So this", "is the issue");
//                                    break;
//
//                                }

                        }

                        if (wonOrLost != 2 && !paused) {

                            wonOrLost = 1;

                        }

                        oneAlreadyRemoved[2] = false;

                        return false;

                    }

                });
            }

            if (numRowsOnScreen >= 4 && !paused) {

                selectionBoxButtons.get(3).addListener(new EventListener() {

                    @Override

                    public boolean handle(Event event) {

                        //Gdx.app.log("Row just tapped", 4 + "");

                        rowJustTapped = 4;

                        for (int j = shapesOnScreen1[3] - 1; j >= 0; j--) {

                            //If the tapped selection box and any shape on the screen are the same color and overlap,

                            if (Intersector.overlaps(shapesRectangles1[3][j], selectionBoxRectangles.get(3)) && currentSelectionBox == shapeColors[3][j] && !paused) {

//                                if (!buttonTapSfx.isPlaying() && !buttonTapSfxAlreadyPlayed) {
//
////                                    buttonTapSfx.play();
//
//                                    buttonTapSfxAlreadyPlayed = true;
//
//                                }

                                oneAlreadyRemoved[3] = true;

                                wonOrLost = 2;

                                clickLoadTimerOn = true;

//                                Gdx.app.log("you scored", "1 point");

                                score++;

                                correctTaps1[3]++;

                                scored = true;

                                shapesOnScreen1[3]--;

                                for (int k = j; k <= shapesOnScreen1[3]; k++) {

                                    randomShapes1[3][k] = randomShapes1[3][k + 1];

                                    shapesRectangles1[3][k] = shapesRectangles1[3][k + 1];

                                    shapeColors[3][k] = shapeColors[3][k + 1];

                                    xPositionShapes[3][k] = xPositionShapes[3][k + 1];

                                    shapeYPositions1[3][k] = shapeYPositions1[3][k + 1];

                                    scaleOfShapes[3][k] = scaleOfShapes[3][k + 1];

                                    xScaleOfShapes[3][k] = xScaleOfShapes[3][k + 1];

                                    yScaleOfShapes[3][k] = yScaleOfShapes[3][k + 1];

                                    progenityCreated[3][k] = progenityCreated[3][k + 1];

                                }


                                //shapeColor.remove(i);

                                oneCorrectBlock = true;

                                tapped = true;

                            }

                            buttonTapSfxAlreadyPlayed = false;
//
//                                if (j < 0) {
//
//                                    Gdx.app.log("So this", "is the issue");
//                                    break;
//
//                                }

                        }

                        if (wonOrLost != 2 && !paused) {

                            wonOrLost = 1;

                        }

                        oneAlreadyRemoved[3] = false;

                        return false;

                    }

                });

            }

            //for each of the four rows,

            for (int j = 0; j < numRowsOnScreen; j++) {

                //for every shape in each row,

                for (int i = 0; i < shapesOnScreen1[j]; i++) {

                    //Adjust the shape's speed based off user score

                    shapeFallSpeed1[j] = originalFallSpeed + (int) (correctTaps1[j] / 13);

                    //If game isn't paused, adjust the y position of each shape on each row by row speed

                    if (!paused) {

                        shapeYPositions1[j][i] += shapeFallSpeed1[j];

                    }

                    //draw a new shape after a while (after previous shape reaches a certain position)

                    if (shapeYPositions1[j][i] >= (screenHeight / 4) && !progenityCreated[j][i]) {

                        progenityCreated[j][i] = true;

                        //Gdx.app.log("Another Shape", "has been created");

                        //And set a random shape for the added shape on the screen

                        if (Math.random() > probNextShapeIsColorOfSelectionBox) {

                            randomNumShape1[j] = rand.nextInt(25);

                        } else {

                            randomNumShape1[j] = currentSelectionBox + (5 * rand.nextInt(5));

                        }


                        //add the new shape to the array of shapes

                        randomShapes1[j][shapesOnScreen1[j]] = shapes[randomNumShape1[j]];

                        progenityCreated[j][shapesOnScreen1[j]] = false;

                        shapesRectangles1[j][shapesOnScreen1[j]] = new Rectangle(xPositionShapes[j][i], screenHeight - shapeYPositions1[j][i], (int)xScaleOfShapes[j][i], (int)yScaleOfShapes[j][i]);

                        //Add another shape to the count of shapes on screen

                        shapesOnScreen1[j]++;

                        for (int k = 0; k < 5; k++) {

                            if (randomNumShape1[j] % 5 == k) {

                                shapeColors[j][shapesOnScreen1[j] - 1] = k;

//							PINK = 0, BLUE = 1, ORANGE = 2, GREEN = 3, PURPLE = 4

                            }

                        }

                        shapeYPositions1[j][shapesOnScreen1[j]] = 0;

                        createShapeTimer = 0;

                    }

                    //If shape is off of screen,

                    if (shapeYPositions1[j][i] > screenHeight + randomShapes1[j][i].getHeight() * 4) {

                        //remove the shape from the appropriate arrays

                        for (int k = 0; k < shapesOnScreen1[j]; k++) {

                            randomShapes1[j][k] = randomShapes1[j][k + 1];

                            shapesRectangles1[j][k] = shapesRectangles1[j][k + 1];

                            shapeColors[j][k] = shapeColors[j][k + 1];

                            xPositionShapes[j][k] = xPositionShapes[j][k + 1];

                            shapeYPositions1[j][k] = shapeYPositions1[j][k + 1];

                            scaleOfShapes[j][k] = scaleOfShapes[j][k + 1];

                            xScaleOfShapes[j][k] = xScaleOfShapes[j][k + 1];

                            yScaleOfShapes[j][k] = yScaleOfShapes[j][k + 1];

                            progenityCreated[j][k] = progenityCreated[j][k + 1];

                        }

                        shapesOnScreen1[j]--;

                    } else if (shapeYPositions1[j][i] > screenHeight + randomShapes1[j][i].getHeight()) {

                        if (currentSelectionBox == shapeColors[j][i]) {

                            gameMode = GAME_OVER;

                        }

                    }

                    //Draw each shape

                    batch.draw(randomShapes1[j][i], xPositionShapes[j][i], screenHeight - shapeYPositions1[j][i], (int)xScaleOfShapes[j][i], (int)yScaleOfShapes[j][i]);

                    //make each shape's rectangles

                    shapesRectangles1[j][i] = new Rectangle(xPositionShapes[j][i], screenHeight - shapeYPositions1[j][i], (int)xScaleOfShapes[j][i], (int)yScaleOfShapes[j][i]);

//                    shapeRenderer.rect(xPositionShapes[j][i], screenHeight - shapeYPositions1[j][i], (int)(xScaleOfShapes[j][i] * .5), (int)(yScaleOfShapes[j][i] * .5));

                }

            }

            //show score ON TOP of the shapes

            font12.getData().setScale(.30f);

            font12.setColor(0,0,0,.4f);

            font12.draw(batch, String.valueOf(score), 100, (float) (screenHeight) - 100);

            font12.setColor(Color.WHITE);

            font12.draw(batch, String.valueOf(score), 95, (float) (screenHeight) - 95);

            oneCorrectBlock = false;

            pauseBtn.setVisible(true);

            pauseBtn.draw(batch,1);

            if (paused) {

                blackOpacity = .5f;

                blackSprite.draw(batch, blackOpacity);

                batch.draw(pauseMenu, (int)(screenWidth / 2 - (pauseMenu.getWidth() * .8) / 2), (int)(screenHeight / 2 - (pauseMenu.getHeight() * .8) / 2), (int)(pauseMenu.getWidth() * .8), (int)(pauseMenu.getHeight() * .8));

                //batch.draw(production, screenWidth / 2 - (int) (production.getWidth() * .4), (int) (screenHeight * .1), (int) (production.getWidth() * .8), (int) (production.getHeight() * .8));

                batch.draw(production, (int)(screenWidth / 2 - (production.getWidth() * .5) / 2), (int)(screenHeight / 2 - (pauseMenu.getHeight() * .9) / 2 + production.getHeight() * .8 * .5), (int)(production.getWidth() * .5), (int)(production.getHeight() * .5));

                homeBtn.setVisible(true);

                homeBtn.draw(batch,1);

                restartBtn.setVisible(true);

                restartBtn.draw(batch,1);

                resumeBtn.setVisible(true);

                resumeBtn.draw(batch,1);

                muteMusicBtn.setVisible(true);

                muteMusicBtn.draw(batch,1);

                muteSfxBtn.setVisible(true);

                muteSfxBtn.draw(batch,1);

                if (!musicPlaying) {

                    batch.draw(x,screenWidth / 2 + 260, (float) (screenHeight * .5) - 35, (int)(x.getWidth() * 1.7), (int)(x.getHeight() * 1.7));

                }
                if (!sfxPlaying) {

                    batch.draw(x,screenWidth / 2 + 270, (float) (screenHeight * .5) + 35, (int) (x.getWidth() * 1.7), (int) (x.getHeight() * 1.7));

                }


                resumeBtn.addListener(new EventListener() {

                    @Override

                    public boolean handle(Event event) {

//                        buttonTapSfx.play();

                        blackOpacity = 0;

                        paused = false;

                        return false;

                    }

                });

                homeBtn.addListener(new EventListener() {

                    @Override

                    public boolean handle(Event event) {

//                        buttonTapSfx.play();

                        gameMode = PLAY_SCREEN;

                        return false;

                    }

                });

                muteMusicBtn.addListener(new EventListener() {

                    @Override

                    public boolean handle(Event event) {

//                        buttonTapSfx.play();

                        if (musicPlaying) {

                            //gameMusic.setVolume(0f);

                            musicPlaying = false;

                        } else {

                            //gameMusic.setVolume(.7f);

                            musicPlaying = true;

                        }

                        return false;

                    }

                });

                muteSfxBtn.addListener(new EventListener() {

                    @Override

                    public boolean handle(Event event) {

                        if (sfxPlaying) {

                            //buttonTapSfx.setVolume(0f);

                            sfxPlaying = false;

                        } else {

                            //buttonTapSfx.setVolume(3f);

                            sfxPlaying = true;

                        }

                        return false;

                    }

                });

            }




            /*          RIDICULOUSLY IMPORTANT CODE BELOW DON'T DELETE!!!         */

//            for (int i = 0; i < numRowsOnScreen; i++) {
//
//                rowJustTapped = i;
//
//                Gdx.app.log("row Not tapped yet asdf",""+ rowJustTapped);
//
//                //Check for a tap on a selection box
//
//                selectionBoxButtons.get(i).addListener(new EventListener() {
//
//                    @Override
//
//                    public boolean handle(Event event) {
//
//                        Gdx.app.log("Number of rows on screen", numRowsOnScreen + "");
//
//                        Gdx.app.log("Row just tapped", rowJustTapped + "");
//
//                        Gdx.app.log("CurrentSelectionBox",currentSelectionBox + "");
//
//                            for (int j = 0; j < shapesOnScreen1[rowJustTapped]; j++) {
//
//                                //If the tapped selection box and any shape on the screen are the same color and overlap,
//
//                                if (Intersector.overlaps(shapesRectangles1[rowJustTapped][j], selectionBoxRectangles.get(rowJustTapped)) && currentSelectionBox == shapeColors[rowJustTapped][j]) {
//
//                                    if (!buttonTapSfx.isPlaying() && !buttonTapSfxAlreadyPlayed) {
//
//                                        buttonTapSfx.play();
//
//                                        buttonTapSfxAlreadyPlayed = true;
//
//                                    }
//
//                                    oneAlreadyRemoved[rowJustTapped] = true;
//
//                                    wonOrLost = 2;
//
//                                    clickLoadTimerOn = true;
//
//                                    Gdx.app.log("you scored", "1 point");
//
//                                    score++;
//
//                                    correctTaps1[rowJustTapped]++;
//
//                                    scored = true;
//
//                                    shapesOnScreen1[rowJustTapped]--;
//
//                                    for (int k = j; k <= shapesOnScreen1[rowJustTapped]; k++) {
//
//                                        randomShapes1[rowJustTapped][k] = randomShapes1[rowJustTapped][k + 1];
//
//                                        shapesRectangles1[rowJustTapped][k] = shapesRectangles1[rowJustTapped][k + 1];
//
//                                        shapeColors[rowJustTapped][k] = shapeColors[rowJustTapped][k + 1];
//
//                                        xPositionShapes[rowJustTapped][k] = xPositionShapes[rowJustTapped][k + 1];
//
//                                        shapeYPositions1[rowJustTapped][k] = shapeYPositions1[rowJustTapped][k + 1];
//
//                                        scaleOfShapes[rowJustTapped][k] = scaleOfShapes[rowJustTapped][k + 1];
//
//                                        progenityCreated[rowJustTapped][k] = progenityCreated[rowJustTapped][k + 1];
//
//                                    }
//
//
//                                    //shapeColor.remove(i);
//
//                                    oneCorrectBlock = true;
//
//                                    tapped = true;
//
//                                }
//
//                                buttonTapSfxAlreadyPlayed = false;
////
////                                if (j < 0) {
////
////                                    Gdx.app.log("So this", "is the issue");
////                                    break;
////
////                                }
//
//                            }
//
//                            if (wonOrLost != 2) {
//
//                                wonOrLost = 1;
//
//                            }
//
//                            oneAlreadyRemoved[rowJustTapped] = false;
//
//                        return false;
//
//                    }
//
//                });
//
//            }



            if (pauseBtnCooldownTimer < 50) {

                pauseBtnCooldownTimer++;

            }

            pauseBtn.addListener(new EventListener() {

                @Override

                public boolean handle(Event event) {

//                    buttonTapSfx.play();
//
//                    if (!paused && pauseBtnCooldownTimer >= 50) {

                        paused = true;
//
//                        pauseBtnCooldownTimer = 0;
//                        pauseBtnCooldownTimer = 0;
//
//                    }

                    return false;
                }

            });


            if(clickLoadTimerOn) {

                clickLoadTimer++;

            }

            if (wonOrLost == 1) {

                gameMode = GAME_OVER;

                Gdx.app.log("Row Tapped before loss",rowJustTapped + "");

                Gdx.app.log("Color of selection Box",currentSelectionBox + "");

                for (int i = 0; i < shapesOnScreen1[rowJustTapped - 1]; i++) {

                    Gdx.app.log("Color of shape Just Tapped",randomShapes1[rowJustTapped - 1][i] + "");

                }

            } else if (clickLoadTimer >= 10){

                wonOrLost = 0;

                clickLoadTimer = 0;

                clickLoadTimerOn = false;

            }


            tapped = false;

            scored = false;

            gameStart = true;

            if (gameMode == GAME_OVER) {

                gameStart = false;

            }

        }

        //Game over screen

        if (gameMode == GAME_OVER) {

            //backgrounds

            batch.draw(ssBg, 0, 0, screenWidth, screenHeight);

            batch.draw(gameBg, 0, 0, screenWidth, screenHeight);

            //score boxes

            if (numRowsOnScreen == 1) {

                batch.draw(selectionBoxes[currentSelectionBox], screenWidth / 2 - (int) (blueSelectionBox.getWidth() * .4), (int) (screenHeight * .05), (int) (blueSelectionBox.getHeight() * .8), (int) (blueSelectionBox.getWidth() * .8));

            } else if (numRowsOnScreen == 2) { // 2 rows of Selection Boxes

                batch.draw(selectionBoxes[currentSelectionBox], (screenWidth - (int) (blueSelectionBox.getWidth() * .6 * 2)) / 3, (int) (screenHeight * .05), (int) (blueSelectionBox.getHeight() * .6), (int) (blueSelectionBox.getWidth() * .6));

                batch.draw(selectionBoxes[currentSelectionBox], screenWidth - (screenWidth - (int) (blueSelectionBox.getWidth() * .6 * 2)) / 3 - (int) (blueSelectionBox.getWidth() * .6), (int) (screenHeight * .05), (int) (blueSelectionBox.getHeight() * .6), (int) (blueSelectionBox.getWidth() * .6));

            } else if (numRowsOnScreen == 3) { // 3 rows of Selection Boxes

                batch.draw(selectionBoxes[currentSelectionBox], (screenWidth - (int) (blueSelectionBox.getWidth() * .5 * 3)) / 4, (int) (screenHeight * .05), (int) (blueSelectionBox.getHeight() * .5), (int) (blueSelectionBox.getWidth() * .5));

                batch.draw(selectionBoxes[currentSelectionBox], screenWidth / 2 - (int) (blueSelectionBox.getWidth() * .25), (int) (screenHeight * .05), (int) (blueSelectionBox.getHeight() * .5), (int) (blueSelectionBox.getWidth() * .5));

                batch.draw(selectionBoxes[currentSelectionBox], screenWidth - (screenWidth - (int) (blueSelectionBox.getWidth() * .5 * 3)) / 4 - (int) (blueSelectionBox.getWidth() * .5), (int) (screenHeight * .05), (int) (blueSelectionBox.getHeight() * .5), (int) (blueSelectionBox.getWidth() * .5));

            } else { // 4 rows of Selection Boxes

                batch.draw(selectionBoxes[currentSelectionBox], (screenWidth - (int) (blueSelectionBox.getWidth() * .4 * 4)) / 5, (int) (screenHeight * .05), (int) (blueSelectionBox.getHeight() * .4), (int) (blueSelectionBox.getWidth() * .4));

                batch.draw(selectionBoxes[currentSelectionBox], 2 * (screenWidth - (int) (blueSelectionBox.getWidth() * .4 * 4)) / 5 + (int) (blueSelectionBox.getWidth() * .4), (int) (screenHeight * .05), (int) (blueSelectionBox.getHeight() * .4), (int) (blueSelectionBox.getWidth() * .4));

                batch.draw(selectionBoxes[currentSelectionBox], 3 * (screenWidth - (int) (blueSelectionBox.getWidth() * .4 * 4)) / 5 + (int) (2 * blueSelectionBox.getWidth() * .4), (int) (screenHeight * .05), (int) (blueSelectionBox.getHeight() * .4), (int) (blueSelectionBox.getWidth() * .4));

                batch.draw(selectionBoxes[currentSelectionBox], 4 * (screenWidth - (int) (blueSelectionBox.getWidth() * .4 * 4)) / 5 + (int) (3 * blueSelectionBox.getWidth() * .4), (int) (screenHeight * .05), (int) (blueSelectionBox.getHeight() * .4), (int) (blueSelectionBox.getWidth() * .4));

            }

            //shapes on screen


            for (int i = 0; i < 4; i++) {

                for (int j = 0; j < shapesOnScreen1[i]; j++) {

                    batch.draw(randomShapes1[i][j], xPositionShapes[i][j], screenHeight - shapeYPositions1[i][j], (int)xScaleOfShapes[i][j], (int)yScaleOfShapes[i][j]);

                }


            }

            font12.getData().setScale(.30f);

            font12.setColor(0,0,0,.4f);

            font12.draw(batch, String.valueOf(score), 100, (float) (screenHeight) - 100);

            font12.setColor(Color.WHITE);

            font12.draw(batch, String.valueOf(score), 95, (float) (screenHeight) - 95);

            pauseBtn.draw(batch,1);

            blackSprite.draw(batch, blackOpacity);

            if (blackOpacity <= .75f) {

                blackOpacity += .01;

            } else {


                batch.draw(youScoredText, screenWidth / 2 - youScoredText.getWidth() / 2, (int) (screenHeight / 1.5));

                font12.getData().setScale(.72f);

                //Game over, score on middle of screen

                scoreLayout.setText(font12, "" + score);

                font12.setColor(255f,241f,69f,1);

                font12.draw(batch, String.valueOf(score), screenWidth / 2 - scoreLayout.width / 2, (int) (screenHeight / 1.62));

                font12.setColor(Color.WHITE);

                if (gameOverTimerScreenTimer >= gameOverMinTime) {

                    gameOverOkButton.setVisible(true);

                    //batch.draw(okButton,screenWidth / 2 - (int)(okButton.getWidth() / 1.3 / 2), screenHeight / 3, (int)(okButton.getWidth() / 1.3), (int)(okButton.getHeight() / 1.3));

                }

            }

            if (score > highScore) {

                prefs.putInteger("high score", score);

                prefs.flush();

                highScore = prefs.getInteger("high score", 0);

                highScoreLayout.setText(fontLight, "High Score: " + highScore);

                highScoreLabel.setText("High Score: " + highScore);

            }

            gameOverTimerScreenTimer++;

            gameOverOkButton.addListener(new EventListener() {

                @Override

                public boolean handle(Event event) {

//                    buttonTapSfx.play();

                    if (gameOverTimerScreenTimer >= gameOverMinTime) {

//                        if (!buttonTapSfx.isPlaying() && !buttonTapSfxAlreadyPlayed) {
//
////                            buttonTapSfx.play();
//
//                            buttonTapSfxAlreadyPlayed = true;
//
//                        }

                        Gdx.app.log("Game mode", "Play Screen");

                        randomShapes1 = new Texture[4][30];

                        randomShapes1[0][0] = shapes[randomNumShape1[0]];

                        randomShapes1[1][0] = shapes[randomNumShape1[1]];

                        randomShapes1[2][0] = shapes[randomNumShape1[2]];

                        randomShapes1[3][0] = shapes[randomNumShape1[3]];

                        shapesRectangles1 = new Rectangle[4][30];

                        xPositionShapes = new int[4][30];

                        progenityCreated = new boolean[4][30];

                        for (boolean[] a : progenityCreated) {

                            for (boolean b : a) {

                                b = false;

                            }

                        }

                        rowJustTapped = 0;

                        shapeColors = new int[4][30];

                        for (int i = 0; i < 4; i++) {

                            for (int j = 0; j < 5; j++) {

                                if (randomNumShape1[i] % 5 == j) {

                                    shapeColors[i][0] = j;

//				PINK = 0, BLUE = 1, ORANGE = 2, GREEN = 3, PURPLE = 4

                                }

                            }

                        }

                        shapeYPositions1 = new int[4][30];

                        shapeYPositions1[0][0] = 0;

                        shapeYPositions1[1][0] = 0;

                        shapeYPositions1[2][0] = 0;

                        shapeYPositions1[3][0] = 0;

                        scaleOfShapes = new double[4][30];

                        xScaleOfShapes = new double[4][30];

                        yScaleOfShapes = new double[4][30];

                        numRowsOnScreen = 1;

                        wonOrLost = 0;

                        shapesOnScreen1 = new int[]{1, 1, 1, 1};

                        //Row 1

                        randomNumShape1 = new int[] {rand.nextInt(25), rand.nextInt(25), rand.nextInt(25), rand.nextInt(25)};

                        gameMode = PLAY_SCREEN;

                        scored = false;

                        //selectionBoxes[currentSelectionBox]

                        currentSelectionBox = rand.nextInt(5);

                        selectionBox = new TextureRegionDrawable(new TextureRegion(selectionBoxes[currentSelectionBox]));

                        selectionBox2 = new TextureRegionDrawable(new TextureRegion(selectionBoxes[currentSelectionBox]));

                        selectionBox3 = new TextureRegionDrawable(new TextureRegion(selectionBoxes[currentSelectionBox]));

                        selectionBox4 = new TextureRegionDrawable(new TextureRegion(selectionBoxes[currentSelectionBox]));

                        selectionBoxButton = new ImageButton (selectionBox);

                        selectionBoxButton2 = new ImageButton (selectionBox2);

                        selectionBoxButton3 = new ImageButton (selectionBox3);

                        selectionBoxButton4 = new ImageButton (selectionBox4);

                        selectionBoxXPositions = new double[4];

                        selectionBoxXPositions[0] = screenWidth / 2 - (int) (blueSelectionBox.getWidth() * .4);

                        selectionBoxXPositions[1] = screenWidth - (screenWidth - (int) (blueSelectionBox.getWidth() * .6 * 2)) / 3 - (int) (blueSelectionBox.getWidth() * .6);

                        selectionBoxXPositions[2] = screenWidth - (screenWidth - (int) (blueSelectionBox.getWidth() * .5 * 3)) / 4 - (int) (blueSelectionBox.getWidth() * .5);

                        selectionBoxXPositions[3] = 4 * (screenWidth - (int) (blueSelectionBox.getWidth() * .4 * 4)) / 5 + (int) (3 * blueSelectionBox.getWidth() * .4);

                        selectionBoxButton.setSize((int) (blueSelectionBox.getHeight() * .8), (int) (blueSelectionBox.getWidth() * .8));

                        selectionBoxButton.setPosition((int)selectionBoxXPositions[0], (int) (screenHeight * .05));

                        selectionBoxButton2.setSize((int) (blueSelectionBox.getHeight() * .6), (int) (blueSelectionBox.getWidth() * .6));

                        selectionBoxButton2.setPosition((int)selectionBoxXPositions[1], (int) (screenHeight * .05));

                        selectionBoxButton3.setSize((int) (blueSelectionBox.getHeight() * .5), (int) (blueSelectionBox.getWidth() * .5));

                        selectionBoxButton3.setPosition((int)selectionBoxXPositions[2], (int) (screenHeight * .05));

                        selectionBoxButton4.setSize((int) (blueSelectionBox.getHeight() * .4), (int) (blueSelectionBox.getWidth() * .4));

                        selectionBoxButton4.setPosition((int)selectionBoxXPositions[3], (int) (screenHeight * .05));

                        selectionBoxButtons = new ArrayList <ImageButton>();

                        selectionBoxButtons.add(null);

                        selectionBoxButtons.add(null);

                        selectionBoxButtons.add(null);

                        selectionBoxButtons.add(null);

                        selectionBoxButtons.set(0, selectionBoxButton);

                        selectionBoxButtons.set(1, selectionBoxButton2);

                        selectionBoxButtons.set(2, selectionBoxButton3);

                        selectionBoxButtons.set(3, selectionBoxButton4);
//
//                        stage.addActor(selectionBoxButton);
//
//                        stage.addActor(selectionBoxButton2);
//
//                        stage.addActor(selectionBoxButton3);
//
//                        stage.addActor(selectionBoxButton4);
//
                        for (ImageButton i : selectionBoxButtons) {

                            stage.addActor(i);

                        }

                        stage.draw();

                        paused = false;

                        oneGamePlayed = true;

                        lastScore = score;

                        score = 0;

                        blackOpacity = 0f;

                        shapeFallSpeed1 = new int[]{originalFallSpeed, originalFallSpeed, originalFallSpeed, originalFallSpeed};

                        gameOverTimerScreenTimer = 0;

                        correctTaps1 = new int[]{0, 0, 0, 0};

                        createShapeTimer = 0;

                        gameOverOkButton.setVisible(false);

                        selectionBoxRectangles = new ArrayList<Rectangle>();
//
//                        selectionBoxRectangles1 = new Rectangle[4][6];

                        pauseBtnCooldownTimer = 50;

                    }

                    return false;

                }

            });

            buttonTapSfxAlreadyPlayed = false;

            gameStart = true;

        } //End of game over mode
//
//        shapeRenderer.end();

        batch.end();

        if (gameMode != PLAYING) {

            stage.draw();

        }

    }

    @Override

    public void dispose() {

        batch.dispose();

        stage.dispose();

    }

    public void setNotificationHandler(NotificationHandler handler) {

        this.notificationHandler = handler;

    }

    public void deleteObject() {



    }

    @Override

    public void resize(int width, int height) {

//		int WIDTH = Gdx.graphics.getWidth();
//
//		int HEIGHT = Gdx.graphics.getHeight();
//
//		float scale = (float) 1794 / (float) HEIGHT;
//
//		WIDTH = (int) (WIDTH  * scale);
//
//		HEIGHT = (int) (HEIGHT  * scale);
//
//		viewport.update(width, height);
//
//		camera = new OrthographicCamera(WIDTH, HEIGHT);

        viewport.update(width, height);

        stage.getViewport().update(width, height, true);

        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);

        stage.getCamera().position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);

        //camera.position.set(camera.viewportWidth / 2,camera.viewportHeight / 2,0);

    }

}
