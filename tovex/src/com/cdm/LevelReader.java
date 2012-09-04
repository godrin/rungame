package com.cdm;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.cdm.LevelMap.FieldType;

public class LevelReader {
	public static Level read(String campaignFile) {

		FileHandle h = Gdx.files.internal(campaignFile);

		InputStream is = h.read();

		InputStreamReader isr = new InputStreamReader(is);

		LineNumberReader lir = new LineNumberReader(isr);
		String line;

		List<String> lineBuffer = new ArrayList<String>();

		try {
			while ((line = lir.readLine()) != null) {
				line = line.replaceAll("#.*$", "").replaceAll("^ *", "");
				if (line.length() > 0)
					lineBuffer.add(line);
			}
		} catch (IOException e) {
		}

		int w = 0;
		for (String cline : lineBuffer) {
			if (w < cline.length())
				w = cline.length();
		}
		Level level = new Level(w, lineBuffer.size());

		int x, y = lineBuffer.size()-1;
		for (String cline : lineBuffer) {

			for (x = 0; x < w; x++) {
				char c = ' ';
				if (cline.length() > x) {
					c = cline.charAt(x);
				}
				LevelMap.FieldType t = getFieldType(c);
				level.set(x, y, t);

				if (c == 'E')
					level.add(new Enemy(new Position(x, y)));
				if (c == 'S')
					level.add(new Player(new Position(x, y)));
				if (c == 'F')
					level.add(new Finish(new Position(x, y)));
			}

			y--;
		}
		return level;
	}

	private static FieldType getFieldType(char c) {
		if (c == 'X') {
			return FieldType.WALL;
		}
		return FieldType.EMPTY;
	}

}
