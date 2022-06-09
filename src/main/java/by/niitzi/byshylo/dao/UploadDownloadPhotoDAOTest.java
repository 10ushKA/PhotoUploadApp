package by.niitzi.byshylo.dao;

import by.niitzi.byshylo.entity.UserPhoto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertThat;


class UploadDownloadPhotoDAOTest {

    @Mock private static UploadDownloadPhotoDAO uploadDownloadPhotoDAO;

    private UploadDownloadPhotoDAO underTest;
    private UserPhoto user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);//here should be openMocks, but somehow any uploaded version didn't provide this
        underTest = new UploadDownloadPhotoDAO(uploadDownloadPhotoDAO);
    }

    @Test
    void canUploadPhotoFile() throws ClassNotFoundException {
        //Given
        //Optional<UserPhoto> userPhoto = Optional.of(
//                new UserPhoto(
//                        1L,
//                        LocalDateTime.now().plusMinutes(10),
//                        LocalDateTime.now().plusMinutes(50),
//                        "foo",
//                        "fooCode",
//                        true,
//                        null,
//                        null
//                ),
//                new UserPhoto(
//                        2L,
//                        LocalDateTime.now().plusMinutes(15),
//                        LocalDateTime.now().plusMinutes(50),
//                        "bar",
//                        "barCode",
//                        true,
//                        null,
//                        null
//                ),
//                new UserPhoto(
//                        3L,
//                        LocalDateTime.now().plusMinutes(5),
//                        LocalDateTime.now().plusMinutes(50),
//                        "bingo",
//                        "bingoCode",
//                        true,
//                        null,
//                        null
//                )
 //       );
//
//        given(uploadDownloadPhotoDAO.uploadPhotoFile(user)).willReturn(Optional.of(user));
//        //When
//        Optional<UserPhoto> actualInvoked = underTest.uploadPhotoFile(user);
//
//        //Then
//        var expected = "bingoCode";
//        assertThat(actualInvoked).isEqualTo(expected);
//    }
}}