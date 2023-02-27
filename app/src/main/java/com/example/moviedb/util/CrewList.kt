package com.example.moviedb.util

import com.example.moviedb.model.CastCrew

object CrewList {

    fun getCrew() : MutableList<CastCrew> {

        val crew = mutableListOf<CastCrew>()

        val cr1 = CastCrew(
            "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/4QFqRXhpZgAASUkqAAgAAAAEADsBAgAMAAAAyAAAABMCAwABAAAAAQAAAJiCAgAWAAAA1gAAAGmHBAABAAAA7AAAAAAAAAAUAAAAtAAAADsBAgAOAAAAyAAAABMCAwABAAAAAQAAAJiCAgAWAAAA1gAAAGmHBAABAAAA7AAAAAAAAAAsAQAAAQAAACwBAAABAAAAQWRvYmUgUGhvdG9zaG9wIExpZ2h0cm9vbSA1LjcuMSAoV2luZG93cykAMjAxNjowMjowOCAyMTo0NzowMwBEIERpcGFzdXBpbABsAMKpIERpYSBEaXBhc3VwaWwgMjAxNgAGAACQBwAEAAAAMDIzMAOQAgAUAAAAOgEAAASQAgAUAAAATgEAAAGRBwAEAAAAAQIDAACgBwAEAAAAMDEwMAGgAwABAAAA//8AAAAAAAAyMDE2OjAyOjA4IDE4OjU1OjM2ADIwMTY6MDI6MDggMTg6NTU6MzYA/+0COlBob3Rvc2hvcCAzLjAAOEJJTQPtAAAAAAAQASwAAAABAAEBLAAAAAEAAThCSU0ECgAAAAAAAQAAOEJJTQQlAAAAAAAQDkXD+2LxqCSoZHhxCHOSvzhCSU0EBAAAAAAB2BwCAAACAAIcAnoAAmRkHAJ4ALJORVcgWU9SSywgTlkgLSBGRUJSVUFSWSAwODogIERpcmVjdG9yIFRpbSBNaWxsZXIgYXR0ZW5kcyB0aGUgIkRlYWRwb29sIiBmYW4gZXZlbnQgYXQgQU1DIEVtcGlyZSBUaGVhdHJlIG9uIEZlYnJ1YXJ5IDgsIDIwMTYgaW4gTmV3IFlvcmsgQ2l0eS4gIChQaG90byBieSBEIERpcGFzdXBpbC9HZXR0eSBJbWFnZXMpHAJ0ABAyMDE2IEQgRGlwYXN1cGlsHAJzABpHZXR0eSBJbWFnZXMgTm9ydGggQW1lcmljYRwCbgAMR2V0dHkgSW1hZ2VzHAJpABQiRGVhZHBvb2wiIEZhbiBFdmVudBwCZwAJNjAzMjQyMTE1HAJlAA1Vbml0ZWQgU3RhdGVzHAJkAANVU0EcAl8AAk5ZHAJcAAAcAloACE5ldyBZb3JrHAJVAAtDb250cmlidXRvchwCUAALRCBEaXBhc3VwaWwcAjcAFTIwMTYtMDItMDggMDA6MDA6MDAuMBwCKAAAHAIZAAAcAhQAA0FDRRwCFAADRU5UHAIUAANDSU4cAg8AAUUcAgoAABwCBQAIODkxNTAxMjL/4Q6eaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLwA8P3htbCB2ZXJzaW9uPSIxLjAiIGVuY29kaW5nPSJVVEYtOCI/Pjx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNS1jMDIxIDc5LjE1NTc3MiwgMjAxNC8wMS8xMy0xOTo0NDowMCI+PHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj48cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIj48ZGM6dGl0bGUgeG1sbnM6ZGM9Imh0dHA6Ly9wdXJsLm9yZy9kYy9lbGVtZW50cy8xLjEvIj44OTE1MDEyMjwvZGM6dGl0bGU+PGRjOmNyZWF0b3IgeG1sbnM6ZGM9Imh0dHA6Ly9wdXJsLm9yZy9kYy9lbGVtZW50cy8xLjEvIj5EIERpcGFzdXBpbDwvZGM6Y3JlYXRvcj48ZGM6cmlnaHRzIHhtbG5zOmRjPSJodHRwOi8vcHVybC5vcmcvZGMvZWxlbWVudHMvMS4xLyI+MjAxNiBEIERpcGFzdXBpbDwvZGM6cmlnaHRzPjxkYzpzdWJqZWN0IHhtbG5zOmRjPSJodHRwOi8vcHVybC5vcmcvZGMvZWxlbWVudHMvMS4xLyI+PHJkZjpCYWcvPjwvZGM6c3ViamVjdD48ZGM6ZGVzY3JpcHRpb24geG1sbnM6ZGM9Imh0dHA6Ly9wdXJsLm9yZy9kYy9lbGVtZW50cy8xLjEvIj5ORVcgWU9SSywgTlkgLSBGRUJSVUFSWSAwODogIERpcmVjdG9yIFRpbSBNaWxsZXIgYXR0ZW5kcyB0aGUgIkRlYWRwb29sIiBmYW4gZXZlbnQgYXQgQU1DIEVtcGlyZSBUaGVhdHJlIG9uIEZlYnJ1YXJ5IDgsIDIwMTYgaW4gTmV3IFlvcmsgQ2l0eS4gIChQaG90byBieSBEIERpcGFzdXBpbC9HZXR0eSBJbWFnZXMpPC9kYzpkZXNjcmlwdGlvbj48L3JkZjpEZXNjcmlwdGlvbj48cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIj48cGhvdG9zaG9wOkF1dGhvcnNQb3NpdGlvbiB4bWxuczpwaG90b3Nob3A9Imh0dHA6Ly9ucy5hZG9iZS5jb20vcGhvdG9zaG9wLzEuMC8iPkNvbnRyaWJ1dG9yPC9waG90b3Nob3A6QXV0aG9yc1Bvc2l0aW9uPjxwaG90b3Nob3A6Q3JlZGl0IHhtbG5zOnBob3Rvc2hvcD0iaHR0cDovL25zLmFkb2JlLmNvbS9waG90b3Nob3AvMS4wLyI+R2V0dHkgSW1hZ2VzPC9waG90b3Nob3A6Q3JlZGl0PjxwaG90b3Nob3A6U291cmNlIHhtbG5zOnBob3Rvc2hvcD0iaHR0cDovL25zLmFkb2JlLmNvbS9waG90b3Nob3AvMS4wLyI+R2V0dHkgSW1hZ2VzIE5vcnRoIEFtZXJpY2E8L3Bob3Rvc2hvcDpTb3VyY2U+PHBob3Rvc2hvcDpDaXR5IHhtbG5zOnBob3Rvc2hvcD0iaHR0cDovL25zLmFkb2JlLmNvbS9waG90b3Nob3AvMS4wLyI+TmV3IFlvcms8L3Bob3Rvc2hvcDpDaXR5PjxwaG90b3Nob3A6U3RhdGUgeG1sbnM6cGhvdG9zaG9wPSJodHRwOi8vbnMuYWRvYmUuY29tL3Bob3Rvc2hvcC8xLjAvIj5OWTwvcGhvdG9zaG9wOlN0YXRlPjxwaG90b3Nob3A6Q291bnRyeSB4bWxuczpwaG90b3Nob3A9Imh0dHA6Ly9ucy5hZG9iZS5jb20vcGhvdG9zaG9wLzEuMC8iPlVuaXRlZCBTdGF0ZXM8L3Bob3Rvc2hvcDpDb3VudHJ5PjxwaG90b3Nob3A6RGF0ZUNyZWF0ZWQgeG1sbnM6cGhvdG9zaG9wPSJodHRwOi8vbnMuYWRvYmUuY29tL3Bob3Rvc2hvcC8xLjAvIj4yMDE2LTAyLTA4IDAwOjAwOjAwLjA8L3Bob3Rvc2hvcDpEYXRlQ3JlYXRlZD48cGhvdG9zaG9wOkNhdGVnb3J5IHhtbG5zOnBob3Rvc2hvcD0iaHR0cDovL25zLmFkb2JlLmNvbS9waG90b3Nob3AvMS4wLyI+RTwvcGhvdG9zaG9wOkNhdGVnb3J5PjxwaG90b3Nob3A6U3VwcGxlbWVudGFsQ2F0ZWdvcmllcyB4bWxuczpwaG90b3Nob3A9Imh0dHA6Ly9ucy5hZG9iZS5jb20vcGhvdG9zaG9wLzEuMC8iPjxyZGY6QmFnPjxyZGY6bGk+QUNFPC9yZGY6bGk+PHJkZjpsaT5FTlQ8L3JkZjpsaT48cmRmOmxpPkNJTjwvcmRmOmxpPjwvcmRmOkJhZz48L3Bob3Rvc2hvcDpTdXBwbGVtZW50YWxDYXRlZ29yaWVzPjxwaG90b3Nob3A6SGVhZGxpbmUgeG1sbnM6cGhvdG9zaG9wPSJodHRwOi8vbnMuYWRvYmUuY29tL3Bob3Rvc2hvcC8xLjAvIj4iRGVhZHBvb2wiIEZhbiBFdmVudDwvcGhvdG9zaG9wOkhlYWRsaW5lPjxwaG90b3Nob3A6Q2FwdGlvbldyaXRlciB4bWxuczpwaG90b3Nob3A9Imh0dHA6Ly9ucy5hZG9iZ",
            "Tim Miller",
            "Director"
        )
        crew.add(cr1)

        val cr2 = CastCrew(
            "",
            "Greg Berry",
            "Production Designer"
        )
        crew.add(cr2)

        val cr3 = CastCrew(
            "",
            "Nigel Evans",
            "Production Designer"
        )
        crew.add(cr3)

        val cr4 = CastCrew(
            "",
            "Craig Humphries",
            "Movie Art Director"
        )
        crew.add(cr4)

        return crew
    }
}